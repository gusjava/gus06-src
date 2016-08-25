package gus06.entity.gus.sys.script1.access.context.pool.first;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20150903";}


	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		
		Map execution = (Map) get1(context,"execution");
		Map startTag = (Map) get1(execution,"start");
		Map stack = (Map) get1(startTag,"stack");
		Map pool = (Map) get1(stack,"pool");
		
		return pool;
	}
	
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return map.get(key);
	}
}
