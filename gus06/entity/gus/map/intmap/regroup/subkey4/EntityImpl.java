package gus06.entity.gus.map.intmap.regroup.subkey4;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150501";}
	
	public static final int LIMIT = 4;
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		Map m = new HashMap();
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			Integer value = (Integer) map.get(key);
			
			String key1 = key.substring(0,LIMIT);
			append(m,key1,value);
		}
		return m;
	}
	
	
	
	private void append(Map m, String key, Integer value)
	{
		if(!m.containsKey(key))
		m.put(key,value);
		else
		{
			Integer v = (Integer) m.get(key);
			Integer vv = new Integer(v.intValue()+value.intValue());
			m.put(key,vv);
		}
	}
}
