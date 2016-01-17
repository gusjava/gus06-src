package gus06.entity.gus.entitydev.entityname.check.existing;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140829";}


	private Service checkName;
	
	public EntityImpl() throws Exception
	{
		checkName = Outside.service(this,"gus.app.entity.checkname");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		if(checkName.f(name)) return name;
		throw new Exception("Unknown entity name: "+name);
	}
}
