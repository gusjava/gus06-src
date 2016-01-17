package gus06.entity.gus.string.transformfinder.lib.kchar;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150926";}
	
	public static final String OFFSET = "kchar_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("diac",Outside.service(this,"gus.string.transform.character.keep.diacritics"));
		put("digit",Outside.service(this,"gus.string.transform.character.keep.digit"));
		put("letter",Outside.service(this,"gus.string.transform.character.keep.letter"));
		put("distinct",Outside.service(this,"gus.string.transform.character.keep.distinct"));
		put("lower",Outside.service(this,"gus.string.transform.character.keep.lowercase"));
		put("upper",Outside.service(this,"gus.string.transform.character.keep.uppercase"));
		put("first",Outside.service(this,"gus.string.transform.character.keep.first"));
		put("last",Outside.service(this,"gus.string.transform.character.keep.last"));
		put("random",Outside.service(this,"gus.string.transform.character.keep.random"));
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
