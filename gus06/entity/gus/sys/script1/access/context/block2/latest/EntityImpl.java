package gus06.entity.gus.sys.script1.access.context.block2.latest;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160202";}
	
	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		
		Map execution = (Map) get1(context,"execution");
		Map currentTag = (Map) get1(execution,"current");
		Map stack = (Map) get1(currentTag,"stack");
		Map block2 = (Map) get1(stack,"block2");
		
		return block2;
	}
	
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return map.get(key);
	}
}