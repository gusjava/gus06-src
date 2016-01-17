package gus06.entity.gus.string.transform.sequence.count.distinct;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150928";}
	
	public static final String DELIM = ";";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		Set set = new HashSet();
		for(String n:nn) set.add(n);
		
		return ""+set.size();
	}
}
