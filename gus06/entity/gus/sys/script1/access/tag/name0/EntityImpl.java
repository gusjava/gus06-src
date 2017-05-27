package gus06.entity.gus.sys.script1.access.tag.name0;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150902";}
	
	public static final String K_NAME = "name";



	
	
	public Object t(Object obj) throws Exception
	{
		Map tag = (Map) obj;
			
		String name = (String) get(tag,K_NAME);
		return name;
	}
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
