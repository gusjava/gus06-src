package gus06.entity.gus.sys.expression1.apply.op._is_collection;

import gus06.framework.*;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151201";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return Boolean.FALSE;
		return new Boolean(obj instanceof Collection);
	}
}
