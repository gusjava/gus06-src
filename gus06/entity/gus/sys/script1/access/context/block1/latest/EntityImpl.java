package gus06.entity.gus.sys.script1.access.context.block1.latest;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160125";}
	
	
	private Service getCurrent;

	public EntityImpl() throws Exception
	{
		getCurrent = Outside.service(this,"gus.sys.script1.access.context.execution.current");
	}
	

	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		Map currentTag = (Map) getCurrent.t(context);
		
		Map stack = (Map) get1(currentTag,"stack");
		Map block1 = (Map) get1(stack,"block1");
		
		return block1;
	}
	
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return map.get(key);
	}
}
