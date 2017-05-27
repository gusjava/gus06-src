package gus06.entity.gus.map.containsall.key.maptof;

import gus06.framework.*;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160201";}
	
	
	public Object t(Object obj) throws Exception
	{return new F1((Map) obj);}
	
	
	private class F1 implements F
	{
		private Map m;
		public F1(Map m) {this.m = m;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj instanceof Collection)
				return m.keySet().containsAll((Collection) obj);
			if(obj instanceof Map)
				return hasAll(m,(Map) obj);
				
			throw new Exception("Invalid data type: "+obj.getClass().getName());
		}
	}
	
	
	private boolean hasAll(Map map1, Map map2)
	{
		Iterator it = map2.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			if(!map1.containsKey(key)) return false;
			
			Object value1 = map1.get(key);
			Object value2 = map2.get(key);
			if(!value1.equals(value2)) return false;
		}
		return true;
	}
}
