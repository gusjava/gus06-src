package gus06.entity.gus.string.transform.tab.columncount;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}
	
	public static final String DELIM = "\t";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split("\n",-1);
		
		String[] r = n[0].split(DELIM,-1);
		return""+r.length;
	}
}
