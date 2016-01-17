package gus06.entity.gus.string.transformfinder.lib.encode;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150926";}
	
	public static final String OFFSET = "encode_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("hill",Outside.service(this,"gus.string.transform.encoding.hill.encode"));
		put("uu",Outside.service(this,"gus.string.transform.encoding.uu.encode"));
		put("gouvernail",Outside.service(this,"gus.string.transform.encoding.gouvernail.encode"));
		put("datastring",Outside.service(this,"gus.string.transform.encoding.datastring.encode"));
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
