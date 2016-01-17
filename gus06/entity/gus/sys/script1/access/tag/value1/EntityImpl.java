package gus06.entity.gus.sys.script1.access.tag.value1;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public static final String K_VALUE = "value";


	public String creationDate() {return "20150902";}


	
	
	public Object t(Object obj) throws Exception
	{
		Map tag = (Map) obj;
			
		String value = (String) get(tag,K_VALUE);
		if(value==null) throw new Exception("Value not found inside tag ["+tag+"]");
		return value;
	}
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
