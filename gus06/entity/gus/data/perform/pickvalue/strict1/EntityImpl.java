package gus06.entity.gus.data.perform.pickvalue.strict1;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170315";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map) return pick((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Object pick(Map m) throws Exception
	{
		if(m.size()!=1) throw new Exception("Invalid size: "+m.size());
		Object key = m.keySet().iterator().next();
		return m.get(key);
	}
}
