package gus06.entity.gus.map.reverse.map;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170411";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		Map map1 = new HashMap();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = map.get(key);
			map1.put(value,key);
		}
		return map1;
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map map = (Map) obj;
		Map map1 = new HashMap();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = map.get(key);
			map1.put(value,key);
		}
		
		map.clear();
		map.putAll(map1);
	}
}
