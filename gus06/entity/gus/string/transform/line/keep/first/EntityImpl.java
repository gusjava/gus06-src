package gus06.entity.gus.string.transform.line.keep.first;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160620";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		if(n.length==0) return "";
		return n[0];
	}
}
