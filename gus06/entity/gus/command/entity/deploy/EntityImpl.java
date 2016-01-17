package gus06.entity.gus.command.entity.deploy;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140730";}


	private Service deploy;
	private Service checkValid;

	public EntityImpl() throws Exception
	{
		deploy = Outside.service(this,"gus.entitydev.deploy.buildjar");
		checkValid = Outside.service(this,"gus.entitydev.entityname.check.valid");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String name = (String) checkValid.t(obj);
		deploy.p(name);
	}
}
