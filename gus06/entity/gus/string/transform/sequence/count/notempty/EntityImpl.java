package gus06.entity.gus.string.transform.sequence.count.notempty;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150929";}
	
	public static final String DELIM = ";";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		int nb = 0;
		for(String n:nn) if(!n.equals("")) nb++;
		
		return ""+nb;
	}
}
