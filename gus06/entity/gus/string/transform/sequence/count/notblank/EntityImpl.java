package gus06.entity.gus.string.transform.sequence.count.notblank;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160620";}
	
	public static final String DELIM = ";";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		int nb = 0;
		for(String n:nn) if(valid(n)) nb++;
		
		return ""+nb;
	}
	
	private boolean valid(String n)
	{return !n.trim().equals("");}
}
