package gus06.entity.gus.debug.analyze.serviceobj;

import gus06.framework.*;
import java.lang.reflect.Field;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141213";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		System.out.println("service target: "+get(obj,"target"));
		System.out.println("service call: "+get(obj,"src_"));
	}
	
	
	
	private Object get(Object obj, String name) throws Exception
	{
		Class c = obj.getClass();
		Field f = c.getDeclaredField(name);
		f.setAccessible(true);
		return f.get(obj);
	}
}
