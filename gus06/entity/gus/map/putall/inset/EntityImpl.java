package gus06.entity.gus.map.putall.inset;

import gus06.framework.*;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Collection;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160821";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object key = o[1];
		Collection col = (Collection) o[2];
		
		if(!map.containsKey(key))
			map.put(key,new HashSet());
		Set set = (Set) map.get(key);
		set.addAll(col);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object key = o[1];
		Collection col = (Collection) o[2];
		
		Map map1 = new HashMap(map);
		
		if(!map1.containsKey(key))
			map1.put(key,new HashSet());
			
		Set set = (Set) map1.get(key);
		set.addAll(col);
		
		return map1;
	}
}
