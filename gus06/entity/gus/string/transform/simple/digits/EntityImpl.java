package gus06.entity.gus.string.transform.simple.digits;

import gus06.framework.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20150926";}
	
	public static final String DIGITS = "0123456789";
	
	
	public Object t(Object obj) throws Exception
	{return DIGITS;}
	
	public Object g() throws Exception
	{return DIGITS;}
}
