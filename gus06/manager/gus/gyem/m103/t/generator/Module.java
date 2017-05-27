package gus06.manager.gus.gyem.m103.t.generator;

import java.util.Map;
import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, F {

	
	public Object t(Object obj) throws Exception
	{
		String key = (String) obj;
		String value = getValue(key);
		
		if(value==null) return null;
		if(value.equals("null")) return null;
		
		if(value.startsWith("g:"))
		{
			G result = (G) uniqueEntity(value.substring(2));
			return result.g();
		}
		
		if(value.startsWith("i:"))
		{
			I result = (I) uniqueEntity(value.substring(2));
			return result.i();
		}
		
		return uniqueEntity(value);
	}
	
	
	
	public boolean f(Object obj) throws Exception
	{
		String key = (String) obj;
		String value = getValue(key);
		
		if(value==null) return false;
		if(value.equals("null")) return false;
		
		if(value.startsWith(":"))
		{
			return true;
		}
		if(value.startsWith("e:"))
		{
			E result = (E) uniqueEntity(value.substring(2));
			result.e();
			return true;
		}
		if(value.startsWith("r:"))
		{
			Runnable result = (Runnable) uniqueEntity(value.substring(2));
			result.run();
			return true;
		}
		
		uniqueEntity(value);
		return true;
	}
	
	
	
	
	private String getValue(String key) throws Exception
	{
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		if(prop==null || !prop.containsKey(key)) return null;
		return (String) prop.get(key);
	}
	
	
	private Object uniqueEntity(String name) throws Exception
	{return ((T) module(M026_T_ENTITY_UNIQUE)).t(name);}
}