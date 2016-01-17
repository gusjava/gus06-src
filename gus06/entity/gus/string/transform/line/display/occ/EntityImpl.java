package gus06.entity.gus.string.transform.line.display.occ;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}
	
	public static final String DELIM = "\n";
	public static final String DELIM2 = "\t";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		Map map = new HashMap();
		for(int i=0;i<n.length;i++)
		increase(map,n[i]);
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<n.length;i++)
		{
			String line = n[i];
			Integer nbOcc = (Integer) map.get(line);
			b.append(nbOcc.intValue()+DELIM2+line+DELIM);
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	
	private void increase(Map map, String key)
	{
		if(!map.containsKey(key))
		{map.put(key,new Integer(1));return;}
		
		Integer n = (Integer)map.get(key);
		map.put(key,new Integer(n.intValue()+1));
	}
}
