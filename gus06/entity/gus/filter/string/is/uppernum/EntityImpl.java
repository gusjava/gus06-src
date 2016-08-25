package gus06.entity.gus.filter.string.is.uppernum;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160729";}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.matches("[A-Z0-9]+");
	}
}