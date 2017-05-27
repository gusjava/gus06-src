package gus06.entity.gus.sys.xhtmlparser1.analyze2.preparetag;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170131";}


	public static final String K_TYPE = "type";
	public static final String K_VALUE = "value";
	public static final String K_NAME = "name";
	public static final String K_UNTIL = "until";
	
	public static final String T_ROOT = "root";
	public static final String T_ELEMENT = "element";
	public static final String T_COMMENT = "comment";
	
	

	private Service findUntil;
	private Service parseValue;
	
	
	public EntityImpl() throws Exception
	{
		findUntil = Outside.service(this,"gus.sys.xhtmlparser1.analyze2.finduntil");
		parseValue = Outside.service(this,"gus.sys.xhtmlparser1.analyze2.parsevalue");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Map tag = (Map) obj;
		String type = get(tag,K_TYPE);
		String value = get(tag,K_VALUE);
		
		if(type==null) throw new Exception("No type found inside tag");
		
		if(type.equals(T_ROOT))
		{
			put(tag,K_NAME,T_ROOT);
			put(tag,K_UNTIL,"/root");
			return;
		}
		
		if(type.equals(T_ELEMENT))
		{
			value = value.trim();
			if(value.startsWith("!"))
			{
				put(tag,K_TYPE,T_COMMENT);
			}
			else if(value.endsWith("/"))	
			{
				value = value.substring(0,value.length()-1);
				fillNameParams(tag,value);
			}
			else
			{
				fillNameParams(tag,value);
				fillUntil(tag);
			}
		}
	}
	
	
	
	private void fillNameParams(Map tag, String value) throws Exception
	{
		Map m = (Map) parseValue.t(value);
		tag.putAll(m);
	}
	
	
	private void fillUntil(Map tag) throws Exception
	{
		String name = get(tag,K_NAME);
		String until = until(name);
		put(tag,K_UNTIL,until);
	}
	
	
	
	private String until(String name) throws Exception
	{return (String) findUntil.t(name);}
	
	private String get(Map map, String key)
	{return map.containsKey(key)?(String) map.get(key):null;}
	
	private void put(Map map, String key, Object value)
	{if(value!=null) map.put(key,value);}
}
