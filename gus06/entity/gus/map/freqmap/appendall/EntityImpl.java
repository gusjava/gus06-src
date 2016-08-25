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
		Collection col = (Collection) o[1];
		
		appendAll(map,col);
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Collection col = (Collection) o[1];
		
		Map map1 = new HashMap(map);
		appendAll(map1,col);
		return map1;
	}
	
	private void appendAll(Map map, Collection col)
	{
		Iterator it = col.iterator();
		while(it.hasNext()) append(map,it.next());
	}
	
	private void append(Map map, Object key)
	{
		if(!map.containsKey(key))
		{map.put(key,new Integer(1));return;}
		
		Integer n = (Integer) map.get(key);
		map.put(key,new Integer(n.intValue()+1));
	}
}
