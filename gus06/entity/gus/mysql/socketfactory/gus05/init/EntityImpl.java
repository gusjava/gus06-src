package gus06.entity.gus.mysql.socketfactory.gus05.init;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;
import com.mysql.jdbc.Gus05_SocketFactoryHolder;
import com.mysql.jdbc.SocketFactory;
import com.mysql.jdbc.StandardSocketFactory;
import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20170206";}


	private Service socketWrapper;

	public EntityImpl() throws Exception
	{
		socketWrapper = Outside.service(this,"gus.mysql.socketfactory.wrapper");
		Gus05_SocketFactoryHolder.socketFactory = new SocketFactory1();
	}
	
	private Socket wrapSocket(Socket socket)
	{
		try{return (Socket) socketWrapper.t(socket);}
		catch(Exception e){Outside.err(this,"wrapSocket(Socket)",e);}
		return socket;
	}
	
	
	private class SocketFactory1 extends StandardSocketFactory
	{
		private Socket socket1;
		
		public Socket afterHandshake() throws SocketException, IOException {return socket1;}
		public Socket beforeHandshake() throws SocketException, IOException {return socket1;}
		
		public Socket connect(String host, int portNumber, Properties props) throws SocketException, IOException
		{
			Socket socket0 = super.connect(host,portNumber,props);
			socket1 = wrapSocket(socket0);
			return socket1;
		}
	}
}
