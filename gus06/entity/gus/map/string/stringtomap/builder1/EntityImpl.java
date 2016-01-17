package gus06.entity.gus.map.string.stringtomap.builder1;

import gus06.framework.*;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141002";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		HashMap map = new HashMap();
		String[] n = toArray(obj);
		if(n==null) return map;
		
		for(String s:n)
		{
			if(!s.contains("=")) throw new Exception("Invalid rule: "+obj);
			String[] nn = s.split("=",2);
			map.put(nn[0],nn[1]);
		}
		return map;
	}
	
	
	
	
	private String[] toArray(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj.equals("")) return null;
		if(obj instanceof String[]) return (String[]) obj;
		if(obj instanceof String) return ((String) obj).split(DELIM);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
