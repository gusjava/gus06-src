package gus06.entity.gus.sys.webserver1.engine.sender;

import gus06.framework.*;
import java.util.Map;
import java.nio.channels.SocketChannel;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141012";}

	public static final String KEY_CHANNEL = "channel";
	
	
	private Service engine;
	private Service formatOutput;
	private Service processor;
	
	
	public EntityImpl() throws Exception
	{
		engine = Outside.service(this,"gus.sys.webserver1.engine");
		formatOutput = Outside.service(this,"gus.sys.webserver1.format.output");
		processor = Outside.service(this,"gus.sys.webserver1.processor");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map input = (Map) obj;
		Map output = (Map) processor.t(input);
		
		SocketChannel channel = (SocketChannel) input.get(KEY_CHANNEL);
		byte[] ba = (byte[]) formatOutput.t(output);
		engine.p(new Object[]{channel,ba});
	}
}
