package gus06.entity.gus.data.perform.pickkey;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170131";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map) return pick((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object pick(Map m)
	{
		if(m.isEmpty()) return null;
		return m.keySet().iterator().next();
	}
}
