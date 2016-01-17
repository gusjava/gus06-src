package gus06.entity.gus.icon.provider;

import java.util.HashMap;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140719";}

	private Service iconBuilder;
	
	private Map cache;

	public EntityImpl() throws Exception
	{
		iconBuilder = Outside.service(this,"gus.icon.builder");
		
		cache = new HashMap();
	}
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	public Object r(String key) throws Exception
	{
		if(key==null || key.equals("")) return null;
	
		if(!cache.containsKey(key))
		{
			Object value = build(key);
			if(value==null) return null;
			cache.put(key,value);
		}
		return cache.get(key);
	}
	
	
	private Object build(String key) throws Exception
	{return iconBuilder.t(key);}
}
