package gus06.entity.gus.filter.string.is.int1;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160403";}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.matches("-?[0-9]+");
	}
}