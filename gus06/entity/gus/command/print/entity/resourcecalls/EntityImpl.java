package gus06.entity.gus.command.print.entity.resourcecalls;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140827";}


	private Service retrieveSrcCode;
	private Service extract;
	private Service checkName;
	private Service printObject;
	
	
	public EntityImpl() throws Exception
	{
		retrieveSrcCode = Outside.service(this,"gus.entitydev.retrieve.srccode1");
		extract = Outside.service(this,"gus.java.srccode.extract.entity.calls.resource");
		checkName = Outside.service(this,"gus.entitydev.entityname.check.existing");
		printObject = Outside.service(this,"gus.print.object");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		String entityName = (String) checkName.t(obj);
		String src = (String) retrieveSrcCode.t(entityName);
		Object result = extract.t(src);
		printObject.p(result);
	}
}
