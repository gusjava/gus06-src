package gus06.entity.gus.filter.string.is.identifier1;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160403";}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.matches("[a-zA-Z_][a-zA-Z0-9_]*");
	}
}