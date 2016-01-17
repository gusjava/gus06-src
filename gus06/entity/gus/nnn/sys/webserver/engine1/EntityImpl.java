package gus06.entity.gus.nnn.sys.webserver.engine1;

import gus06.framework.*;
import java.nio.channels.*;
import java.nio.ByteBuffer;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.Iterator;
import java.io.IOException;


public class EntityImpl extends S1 implements Entity, G {

	public String creationDate() {return "20140927";}
	
	public static final int PORT = 80;




	public EntityImpl() throws Exception
	{
		System.out.println("Listening for connections on port "+PORT);
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket ss = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(PORT);
		ss.bind(address);
		serverChannel.configureBlocking(false);
		Selector selector = Selector.open();
		serverChannel.register(selector,SelectionKey.OP_ACCEPT);
		
		while(true)
		{
			try{selector.select();}
			catch(IOException ex)
			{
				ex.printStackTrace();
				break;
			}
		}
		
		Set readyKeys = selector.selectedKeys();
		Iterator iterator = readyKeys.iterator();
		while(iterator.hasNext())
		{
			SelectionKey key = (SelectionKey) iterator.next();
			iterator.remove();
			
			try
			{
				if(key.isAcceptable())
				{
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = server.accept();
					System.out.println("Accepted connection from "+client);
					client.configureBlocking(false);
					client.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ,ByteBuffer.allocate(100));
				}
				if(key.isReadable())
				{
					SocketChannel client = (SocketChannel) key.channel();
					ByteBuffer output = (ByteBuffer) key.attachment();
					client.read(output);
				}
				if(key.isWritable())
				{
					SocketChannel client = (SocketChannel) key.channel();
					ByteBuffer output = (ByteBuffer) key.attachment();
					output.flip();
					client.write(output);
					output.compact();
				}
			}
			catch(IOException ex)
			{
				key.cancel();
				try{key.channel().close();}
				catch(IOException cex) {}
			}
		}
	}
	
	
	
	
	
	
	
	public Object g() throws Exception
	{
		return null;
	}
}
