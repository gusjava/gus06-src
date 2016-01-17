package gus06.entity.gus.command.entity.compile;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140725";}


	private Service compiler;
	private Service checkValid;
	
	
	public EntityImpl() throws Exception
	{
		compiler = Outside.service(this,"gus.java.compiler.entity");
		checkValid = Outside.service(this,"gus.entitydev.entityname.check.valid");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String name = (String) checkValid.t(obj);
		compiler.p(name);
	}
}
