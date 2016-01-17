package gus06.entity.gus.string.transformfinder.lib.format;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150926";}
	
	public static final String OFFSET = "format_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("brackets_curly",Outside.service(this,"gus.string.transform.format.brackets.curly"));
		put("datasize_fr",Outside.service(this,"gus.string.transform.format.datasize.fr"));
		put("datasize_en",Outside.service(this,"gus.string.transform.format.datasize.en"));
		put("duration_fr",Outside.service(this,"gus.string.transform.format.duration.fr"));
		put("html_encode",Outside.service(this,"gus.string.transform.format.html.encode"));
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
