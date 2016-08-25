package gus06.entity.gus.map.maparray.merge.engine1;

import gus06.framework.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160227";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map[] mm = (Map[]) obj;
		Map map = new HashMap();
		for(Map m:mm) addToMap(map,m);
		return map;
	}
	
	
	private void addToMap(Map map0, Map map)
	{
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = get(map,key);
			Object value0 = get(map0,key);
			
			map0.put(key,merge(value0,value));
		}
	}
	
	
	private void addToList(List list0, List list)
	{
		list0.addAll(list);
	}
	
	
	private void addToSet(Set set0, Set set)
	{
		set0.addAll(set);
	}
	
	
	
	
	
	private Object merge(Object value0, Object value)
	{
		if(value0==null) return value;
		if(value==null) return value0;
		
		if(value instanceof Map && value0 instanceof Map)
		{
			Map m = new HashMap((Map) value0);
			addToMap(m,(Map) value);
			return m;
		}
		if(value instanceof List && value0 instanceof List)
		{
			List l = new ArrayList((List) value0);
			addToList(l,(List) value);
			return l;
		}
		if(value instanceof Set && value0 instanceof Set)
		{
			Set s = new HashSet((Set) value0);
			addToSet(s,(Set) value);
			return s;
		}
		
		return value;
	}
	
	
	
	private Object get(Map map, Object key)
	{return map.containsKey(key)?map.get(key):null;}
}
