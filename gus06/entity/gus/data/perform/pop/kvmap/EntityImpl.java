package gus06.entity.gus.data.perform.pop.kvmap;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170419";}
	
	public static final String KEY = "key";
	public static final String VALUE = "value";
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map) return pop((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object pop(Map m)
	{
		if(m.isEmpty()) return null;
		Object key = m.keySet().iterator().next();
		Object value = m.remove(key);
		
		Map m1 = new HashMap();
		m1.put(KEY,key);
		m1.put(VALUE,value);
		return m1;
	}
}
