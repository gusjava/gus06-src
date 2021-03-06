package gus06.entity.gus.string.transformfinder.lib.regexp;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20151014";}
	
	public static final String OFFSET = "regexp_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("email",Outside.service(this,"gus.string.transform.regexp.extract.email"));
		put("url",Outside.service(this,"gus.string.transform.regexp.extract.url"));
		put("titled",Outside.service(this,"gus.string.transform.regexp.extract.titled"));
	}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(map.containsKey(s)) return map.get(s);
		return null;
	}
	
	public Object g() throws Exception
	{return map;}
}
