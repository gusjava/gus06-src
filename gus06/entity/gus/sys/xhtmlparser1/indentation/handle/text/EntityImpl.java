package gus06.entity.gus.sys.xhtmlparser1.indentation.handle.text;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170226";}
	
	public static final String K_VALUE = "value";
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		StringBuffer b = (StringBuffer) o[0];
		Map map = (Map) o[1];
		String offset = (String) o[2];
		
		String text = value(map).trim();
		if(text.equals("")) return;
		
		String[] nn = text.split("\n");
		for(String n:nn) b.append(offset+format(n)+"\n");
	}
	
	
	private String value(Map map) throws Exception
	{return (String) get1(map,K_VALUE);}
	
	
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return  map.get(key);
	}
	
	
	private String format(String s)
	{
		return s.trim().replaceAll("[ \t\n]+"," ");
	}
}
