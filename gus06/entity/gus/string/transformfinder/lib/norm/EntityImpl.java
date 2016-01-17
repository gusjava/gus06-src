package gus06.entity.gus.string.transformfinder.lib.norm;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150926";}
	
	public static final String OFFSET = "norm_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("diac",Outside.service(this,"gus.string.transform.normalize.diacritics"));
		put("diac_lower",Outside.service(this,"gus.string.transform.normalize.diacritics.lower"));
		put("diac_upper",Outside.service(this,"gus.string.transform.normalize.diacritics.upper"));
		put("diac_glued",Outside.service(this,"gus.string.transform.normalize.diacritics.lower.glued"));
		put("filename",Outside.service(this,"gus.string.transform.normalize.filename"));
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
