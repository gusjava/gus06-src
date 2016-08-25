package gus06.entity.gus.convert.booleantointeger;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160626";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		boolean v = ((Boolean)obj).booleanValue();
		return new Integer(v ? 1 : 0);
	}
}
