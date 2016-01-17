package gus06.entity.gus.find.obj1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140907";}


	private Service findClass;


	public EntityImpl() throws Exception
	{
		findClass = Outside.service(this,"gus.find.class1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Class c = (Class) findClass.t(obj);
		return c.newInstance();
	}
}
