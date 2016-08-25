package gus06.entity.gus.map.string.stringtomap.builder3.urldecoding;

import gus06.framework.*;
import java.util.HashMap;
import java.net.URLDecoder;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141013";}


	private Service decoder;
	
	public static final String DELIM = "&";
	
	public EntityImpl() throws Exception
	{
		decoder = Outside.service(this,"gus.string.transform.encoding.url.decode");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		HashMap map = new HashMap();
		String[] n = toArray(obj);
		if(n==null) return map;
		
		for(String s:n)
		{
			if(!s.contains("=")) throw new Exception("Invalid rule: "+obj);
			String[] nn = s.split("=",2);
			map.put(decode(nn[0]),decode(nn[1]));
		}
		return map;
	}
	
	
	private String decode(String s) throws Exception
	{return (String) decoder.t(s);}
	
	
	
	
	private String[] toArray(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj.equals("")) return null;
		if(obj instanceof String[]) return (String[]) obj;
		if(obj instanceof String) return ((String) obj).split(DELIM);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
