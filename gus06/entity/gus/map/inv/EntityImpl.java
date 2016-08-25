package gus06.entity.gus.map.inv;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160129";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		Map map1 = new HashMap();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = map.get(key);
			
			if(!map1.containsKey(value))
				map1.put(value,new HashSet());
			Set set = (Set) map1.get(value);
			set.add(key);
		}
		
		return map1;
	}
}
