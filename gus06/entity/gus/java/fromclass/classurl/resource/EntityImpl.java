package gus06.entity.gus.java.fromclass.classurl.resource;

import gus06.framework.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Class c = (Class) obj;
		String name = "/"+c.getName().replace(".","/")+".class";
		return c.getResource(name);
	}
}
