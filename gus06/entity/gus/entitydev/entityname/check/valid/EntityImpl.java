package gus06.entity.gus.entitydev.entityname.check.valid;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140902";}


	private Service isValid;
	
	public EntityImpl() throws Exception
	{
		isValid = Outside.service(this,"gus.app.entity.isvalid");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		if(!isValid.f(name)) throw new Exception("Invalid entity name: "+name);
		return name;
	}
}
