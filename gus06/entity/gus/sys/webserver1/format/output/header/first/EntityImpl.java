package gus06.entity.gus.sys.webserver1.format.output.header.first;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141107";}

	public static final String KEY_CODE = "code";
	public static final String KEY_VERSION = "version";
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		String code = (String) get(map,KEY_CODE);
		String version = (String) get(map,KEY_VERSION);
		
		return version+" "+messageCode(code);
	}
	
	
	private Object get(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return map.get(key);
	}
	
	private String messageCode(String code) throws Exception
	{
		if(code.equals("200")) return "200 OK";
		if(code.equals("404")) return "404 Not Found";
		if(code.equals("500")) return "500 Internal Server Error";
		
		throw new Exception("Invalid HTTP return code: "+code);
	}
}
