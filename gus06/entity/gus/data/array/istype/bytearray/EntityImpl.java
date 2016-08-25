package gus06.entity.gus.data.array.istype.bytearray;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160308";}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		for(Object o:oo) if(!(o instanceof byte[])) return false;
		return true;
	}
}