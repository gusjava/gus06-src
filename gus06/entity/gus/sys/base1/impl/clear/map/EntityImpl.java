package gus06.entity.gus.sys.base1.impl.clear.map;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150807";}
	
	public static final String TYPE = "type";


	private Service clearJdbc;


	public EntityImpl() throws Exception
	{
		clearJdbc = Outside.service(this,"gus.sys.base1.impl.clear.map.jdbc");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		String type = (String) get(map,TYPE);
		if(type.equals("jdbc")) {clearJdbc.p(obj);return;}
		
		throw new Exception("Unsupported base type: "+type);
	}
	
	
	private Object get(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return map.get(key);
	}
}
