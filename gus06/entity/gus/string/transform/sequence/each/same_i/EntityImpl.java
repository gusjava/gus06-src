package gus06.entity.gus.string.transform.sequence.each.same_i;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160622";}
	
	public static final String DELIM = ";";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		if(nn.length==0) return "false";
		
		String n0 = format(nn[0]);
		for(String n:nn)
		{
			if(!format(n).equals(n0)) return "false";
		}
		return "true";
	}
	
	private String format(String s)
	{return s.toLowerCase();}
}
