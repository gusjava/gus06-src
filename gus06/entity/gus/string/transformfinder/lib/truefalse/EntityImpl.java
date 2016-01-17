package gus06.entity.gus.string.transformfinder.lib.truefalse;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150926";}
	
	public static final String OFFSET = "truefalse_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("invert",Outside.service(this,"gus.string.transform.truefalse.invert"));
		
		put("checkempty",Outside.service(this,"gus.string.transform.truefalse.checkempty"));
		put("checkzero",Outside.service(this,"gus.string.transform.truefalse.checkzero"));
		put("checkpalyndrome",Outside.service(this,"gus.string.transform.truefalse.checkpalyndrome"));
		
		put("clearfalse",Outside.service(this,"gus.string.transform.truefalse.clearfalse"));
		put("cleartrue",Outside.service(this,"gus.string.transform.truefalse.cleartrue"));
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
