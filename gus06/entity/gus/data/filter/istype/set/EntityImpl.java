package gus06.entity.gus.data.filter.istype.set;

import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160818";}
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;
		return obj instanceof Set;
	}
	
}
