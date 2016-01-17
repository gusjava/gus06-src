package gus06.entity.gus.data.filter.isnull;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20141021";}
	
	public boolean f(Object obj) throws Exception
	{return obj==null;}
}
