package gus06.entity.gus.sys.webserver1.engine;

import gus06.framework.*;
import java.nio.channels.*;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.util.*;
import java.io.PrintStream;


public class EntityImpl implements Entity, P, E, Runnable {

	public String creationDate() {return "20140927";}

	public static final int DEFAULT_PORT = 80;
	public static final int BUFFSIZE = 8192;
	public static final String KEY_PORT = "app.webserver.port";



	private Service receiver;
	private PrintStream out;
	private Map prop;

	private Thread t;
	private Selector selector;
	private ByteBuffer readBuffer;
	private Map pending;
	private int port;
	
	
	
	public EntityImpl() throws Exception
	{
		receiver = Outside.service(this,"gus.sys.webserver1.engine.receiver");
		out = (PrintStream) Outside.resource(this,"sysout");
		prop = (Map) Outside.resource(this,"prop");
		
		pending = new HashMap();
		port = prop.containsKey(KEY_PORT)?intProp(KEY_PORT):DEFAULT_PORT;
	}
	
	
	
	public void e() throws Exception
	{
		receiver.e();
		
		if(t!=null && t.isAlive()) return;
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
	}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		SocketChannel socketChannel = (SocketChannel) o[0];
		byte[] data = (byte[]) o[1];
		
		synchronized(pending)
		{enqueueByteBuffer(pending,socketChannel,data);}
		
		selector.wakeup();
	}
	
	
	
	
	
	
	
	
	
	
	public void run()
	{
		if(initServer())
		while(true) {perform();sleep1();}
	}
	
	
	
	private void sleep1()
	{
		try{Thread.sleep(1);}
		catch(Exception e){Outside.err(this,"sleep1()",e);}
	}

	
	
	
	private boolean initServer()
	{
		try
		{
			readBuffer = ByteBuffer.allocate(BUFFSIZE);
			selector = Selector.open();
			
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.socket().bind(new InetSocketAddress(port));
			serverChannel.configureBlocking(false);
			serverChannel.register(selector,SelectionKey.OP_ACCEPT);
			
			out.println("Web Server started on port: "+port);
			return true;
		}
		catch(Exception e)
		{
			Outside.err(this,"initServer()",e);
			return false;
		}
	}

	
	
	private void perform()
	{
		try
		{
			registerPending();
			selector.select();
			Iterator it = selector.selectedKeys().iterator();
			while(it.hasNext())
			{
				handleKey((SelectionKey) it.next());
				it.remove();
			}
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
	
	

	private void handleKey(SelectionKey key) throws Exception
	{
		if(!key.isValid()) return;

		if(key.isAcceptable()) acceptKey(key);
		else if(key.isReadable()) readKey(key);
		else if(key.isWritable()) writeKey(key);
	}



	private void acceptKey(SelectionKey key) throws Exception
	{
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(selector,SelectionKey.OP_READ);
	}
	
	
	
	private void readKey(SelectionKey key) throws Exception
	{
		SocketChannel socketChannel = (SocketChannel) key.channel();
		readBuffer.clear();

		int nbRead;
		try{nbRead = socketChannel.read(readBuffer);}
		catch(Exception e)
		{
			key.cancel();
			socketChannel.close();
			return;
		}
		if(nbRead == -1)
		{
			key.cancel();
			socketChannel.close();
			return;
		}
		
		byte[] data = new byte[nbRead];
		System.arraycopy(readBuffer.array(),0,data,0,nbRead);
		receiver.p(new Object[]{socketChannel,data});
	}
	
	
	
	
	
	private void writeKey(SelectionKey key) throws Exception
	{
		SocketChannel socketChannel = (SocketChannel) key.channel();
		
		synchronized(pending)
		{
			if(!pending.containsKey(socketChannel))
			{key.interestOps(SelectionKey.OP_READ);return;}
			
			List queue = (List) pending.get(socketChannel);
			while(!queue.isEmpty())
			{
				ByteBuffer buf = (ByteBuffer) queue.get(0);
				socketChannel.write(buf);
				if(buf.remaining()>0) break;
				queue.remove(0);
			}
			if(queue.isEmpty())
			{
				pending.remove(socketChannel);
				
				// CHOOSE ONE, DEPENDING ON HTTP 1.0 OR 1.1
				key.interestOps(SelectionKey.OP_READ); // FOR HTTP 1.1
				socketChannel.close(); // FOR HTTP 1.0
			}
		}
	}
	
	
	
	private void registerPending() throws Exception
	{
		synchronized(pending)
		{
			Iterator it = pending.keySet().iterator();
			while(it.hasNext())
			{
				SocketChannel socketChannel = (SocketChannel) it.next();
				SelectionKey key = socketChannel.keyFor(selector);
				
				if(key==null) it.remove();
				else key.interestOps(SelectionKey.OP_WRITE);
			}
		}
	}
	
	
	
	private void enqueueByteBuffer(Map map, Object key, byte[] data)
	{
		if(!map.containsKey(key)) map.put(key,new ArrayList());
		List queue = (List) map.get(key);
		queue.add(ByteBuffer.wrap(data));
	}
	
	
	
	private int intProp(String key)
	{return Integer.parseInt((String) prop.get(key));}
}
