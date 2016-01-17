package gus06.entity.gus.command.print.entitysrc;

import java.io.PrintStream;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140713";}


	private Service retrieveSrcCode;
	private Service checkName;
	private PrintStream out;
	
	
	public EntityImpl() throws Exception
	{
		retrieveSrcCode = Outside.service(this,"gus.entitydev.retrieve.srccode1");
		checkName = Outside.service(this,"gus.entitydev.entityname.check.existing");
		out = (PrintStream) Outside.resource(this,"sysout");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		String entityName = (String) checkName.t(obj);
		String srcCode = (String) retrieveSrcCode.t(entityName);
		
		out.println(srcCode);
	}
}
