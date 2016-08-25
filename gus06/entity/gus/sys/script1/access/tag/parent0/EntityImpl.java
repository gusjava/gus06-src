package gus06.entity.gus.sys.script1.access.tag.parent0;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public static final String K_PARENT = "parent";


	public String creationDate() {return "20160327";}


	
	
	public Object t(Object obj) throws Exception
	{
		Map tag = (Map) obj;
		return get(tag,K_PARENT);
	}
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
