package gus06.entity.gus.string.transform.line.remove.doubloon;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141105";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		StringBuffer b = new StringBuffer();
		HashSet set = new HashSet();
		
		for(int i=0;i<n.length;i++)
		if(!set.contains(n[i]))
		{
		    set.add(n[i]);
		    b.append(n[i]+DELIM);
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
