package gus06.entity.gus.map.remove;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161215";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object key = o[1];
		
		map.remove(key);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		Object key = o[1];
		
		Map map1 = new HashMap(map);
		map1.remove(key);
		return map1;
	}
}
