package gus06.entity.gus.sys.cmd1.engine;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150626";}


	private Service alias;
	private Service buildOp;
	private Service buildData;


	public EntityImpl() throws Exception
	{
		alias = Outside.service(this,"gus.sys.cmd1.alias");
		buildOp = Outside.service(this,"gus.sys.cmd1.builder.op");
		buildData = Outside.service(this,"gus.sys.cmd1.builder.data");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String cmd = (String) alias.r((String) obj);
		if(!cmd.contains(" ")) cmd = "e "+cmd;
		
		String[] n = cmd.split(" ",2);
		String op = n[0];
		String info = n[1];
		
		Object data = buildData.t(info);
		P op_ = (P) buildOp.t(op);
		op_.p(data);
	}
}
