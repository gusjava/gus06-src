package gus06.entity.gus.string.transformfinder.lib.str;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150926";}
	
	public static final String OFFSET = "str_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("double",Outside.service(this,"gus.string.transform.str.double1"));
		put("empty",Outside.service(this,"gus.string.transform.str.empty"));
		put("length",Outside.service(this,"gus.string.transform.str.length"));
		put("lower",Outside.service(this,"gus.string.transform.str.lower"));
		put("now",Outside.service(this,"gus.string.transform.str.now"));
		put("same",Outside.service(this,"gus.string.transform.str.same"));
		put("spacing",Outside.service(this,"gus.string.transform.str.spacing"));
		put("titled",Outside.service(this,"gus.string.transform.str.titled"));
		put("titled_inv",Outside.service(this,"gus.string.transform.str.titled.inv"));
		put("trim",Outside.service(this,"gus.string.transform.str.trim"));
		put("trimf",Outside.service(this,"gus.string.transform.str.trimfirst"));
		put("triml",Outside.service(this,"gus.string.transform.str.trimlast"));
		put("trimnw",Outside.service(this,"gus.string.transform.str.trim.ifnotwhite"));
		put("trimw",Outside.service(this,"gus.string.transform.str.trim.ifwhite"));
		put("triple",Outside.service(this,"gus.string.transform.str.triple"));
		put("upper",Outside.service(this,"gus.string.transform.str.upper"));
		put("whiten",Outside.service(this,"gus.string.transform.str.whiten"));
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
