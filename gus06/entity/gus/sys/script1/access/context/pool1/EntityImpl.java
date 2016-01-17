package gus06.entity.gus.sys.script1.access.context.pool1;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20150903";}
	
	public static final String C_POOL = "pool";


	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
			
		Map pool = (Map) get(context,C_POOL);
		if(pool==null) throw new Exception("Pool not found inside context");
		return pool;
	}
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
