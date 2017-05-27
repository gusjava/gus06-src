package gus06.entity.gus.map.freqmap.appendall;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160821";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object data = o[1];
		
		appendAll(map,data);
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object data = o[1];
		
		Map map1 = new HashMap(map);
		appendAll(map1,data);
		return map1;
	}
	
	
	
	
	private void appendAll(Map map, Object data) throws Exception
	{
		if(data instanceof Collection)
			appendAll(map,(Collection) data);
		else if(data instanceof Iterator)
			appendAll(map,(Iterator) data);
		else if(data instanceof Map)
			appendAll(map,(Map) data);
		else throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	private void appendAll(Map map, Collection col)
	{
		Iterator it = col.iterator();
		while(it.hasNext()) append(map,it.next());
	}
	
	private void appendAll(Map map, Iterator it)
	{
		while(it.hasNext()) append(map,it.next());
	}
	
	private void appendAll(Map map, Map m)
	{
		Iterator it = m.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Integer k = (Integer) m.get(key);
			append(map,key,k);
		}
	}
	
	
	
	
	
	
	private void append(Map map, Object key)
	{
		if(!map.containsKey(key))
		{map.put(key,new Integer(1));return;}
		
		Integer n = (Integer) map.get(key);
		map.put(key,new Integer(n.intValue()+1));
	}
	
	private void append(Map map, Object key, Integer k)
	{
		if(!map.containsKey(key))
		{map.put(key,k);return;}
		
		Integer n = (Integer) map.get(key);
		map.put(key,new Integer(n.intValue()+k.intValue()));
	}
}
