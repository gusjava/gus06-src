package gus06.entity.gus.sys.expression1.apply.op._notevery;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151116";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof boolean[]) return notEvery((boolean[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Boolean notEvery(boolean[] array)
	{
		for(boolean n:array) if(!n) return Boolean.TRUE;
		return Boolean.FALSE;
	}
}
