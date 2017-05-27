package gus06.entity.gus.data.perform.pop.kvarray.strict01;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170419";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map) return pop((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object pop(Map m) throws Exception
	{
		if(m.isEmpty()) return null;
		if(m.size()!=1) throw new Exception("Invalid size: "+m.size());
		Object key = m.keySet().iterator().next();
		Object value = m.remove(key);
		return new Object[]{key,value};
	}
}
