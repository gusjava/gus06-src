package gus06.entity.gus.sys.webserver1.web3.processor2;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160216";}
	
	

	private Service prepare;
	private Service handle;
	private Service output;

	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.webserver1.web3.processor2.prepare");
		handle = Outside.service(this,"gus.sys.webserver1.web3.processor2.handle");
		output = Outside.service(this,"gus.sys.webserver1.web3.processor2.output");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object data = prepare.t(obj);
		handle.p(data);
		return output.t(data);
	}
}
