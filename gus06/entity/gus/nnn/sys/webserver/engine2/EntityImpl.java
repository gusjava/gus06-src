package gus06.entity.gus.nnn.sys.webserver.engine2;

import gus06.framework.*;
import java.nio.channels.*;
import java.nio.ByteBuffer;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.Iterator;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;


public class EntityImpl extends S1 implements Entity, G {

	public String creationDate() {return "20140927";}
	
	public static final int PORT = 80;




	public EntityImpl() throws Exception
	{
		System.out.println("Listening for connections on port "+PORT);
		final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(PORT);
		serverChannel.bind(address);
		final CountDownLatch latch = new CountDownLatch(1);
		serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel,Object>()
		{
			public void completed(final AsynchronousSocketChannel channel,Object attachment)
			{
				serverChannel.accept(null, this);
				ByteBuffer buffer = ByteBuffer.allocate(100);
				channel.read(buffer,buffer,new EchoCompletionHandler(channel));
			}
			public void failed(Throwable throwable, Object attachment)
			{
				try{serverChannel.close();}
				catch(IOException e){}
				finally{latch.countDown();}
			}
		});
		
		try{latch.await();}
		catch(InterruptedException e)
		{Thread.currentThread().interrupt();}
	}
	
	
	
	private final class EchoCompletionHandler implements CompletionHandler<Integer, ByteBuffer>
	{
		private final AsynchronousSocketChannel channel;
		
		EchoCompletionHandler(AsynchronousSocketChannel channel)
		{this.channel = channel;}
		
		public void completed(Integer result, ByteBuffer buffer)
		{
			buffer.flip();
			channel.write(buffer, buffer, new CompletionHandler<Integer,ByteBuffer>()
			{
				public void completed(Integer result, ByteBuffer buffer)
				{
					if (buffer.hasRemaining())
					{channel.write(buffer, buffer, this);}
					else
					{
						buffer.compact();
						channel.read(buffer, buffer,
						EchoCompletionHandler.this);
					}
				}
				public void failed(Throwable exc, ByteBuffer attachment)
				{
					try{channel.close();}
					catch(IOException e){}
				}
			});
		}
		
		public void failed(Throwable exc, ByteBuffer attachment)
		{
			try{channel.close();}
			catch(IOException e) {}
		}
	}
		
		
	
	public Object g() throws Exception
	{
		return null;
	}
}
