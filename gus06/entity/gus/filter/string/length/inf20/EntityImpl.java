package gus06.entity.gus.filter.string.length.inf20;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160817";}
	
	public static final int LIMIT = 20;
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.length()<=LIMIT;
	}
}