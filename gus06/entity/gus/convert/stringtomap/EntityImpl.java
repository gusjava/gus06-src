package gus06.entity.gus.convert.stringtomap;

import gus06.framework.*;
import java.util.HashMap;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140911";}


	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String delim = findDelim(s);
		String[] lines = s.split("\n");
		
		HashMap map = new HashMap();
		for(int i=0;i<lines.length;i++)
		{
			String[] n = lines[i].split(delim,2);
			if(n.length!=2) throw new Exception("Invalid text: "+s);
			map.put(n[0],n[1]);
		}
		return map;
	}
	
	
	private String findDelim(String s) throws Exception
	{
		if(s.contains("\t")) return "\t";
		if(s.contains("=")) return "=";
		throw new Exception("Invalid text: "+s);
	}
}
