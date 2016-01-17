package gus06.entity.gus.sys.script1.analyze1.buildtag.newmap;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public static final String T_ROOT = "root";
	public static final String T_ELEMENT = "element";
	public static final String T_TEXT = "text";
	
	public static final String K_TYPE = "type";
	public static final String K_NAME = "name";
	
	public String creationDate() {return "20150830";}


	private Service buildMap;

	
	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.map.map2");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		String type = (String) obj;
		Map map = (Map) buildMap.t(new T1());
		map.put(K_TYPE,type);
		return map;
	}
	
	
	
	private class T1 implements T
	{
		public Object t(Object obj) throws Exception
		{
			Map map = (Map) obj;
			
			String type = getString(map,K_TYPE);
			String name = getString(map,K_NAME);
		
			if(type.equals(T_ROOT)) return "root";
			if(type.equals(T_TEXT)) return "text";
			if(type.equals(T_ELEMENT)) return "element:"+name;
		
			return "?"+type;
		}
		
		private String getString(Map map, String key)
		{
			if(!map.containsKey(key)) return "null";
			return (String) map.get(key);
		}
	}
}
