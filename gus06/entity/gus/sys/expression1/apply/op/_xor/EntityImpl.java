package gus06.entity.gus.sys.expression1.apply.op._xor;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof boolean[]) return xor((boolean[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Boolean xor(boolean[] array)
	{
		if(array.length==0) return Boolean.TRUE;
		boolean a = array[0];
		for(boolean n:array) if(n!=a) return Boolean.FALSE;
		return Boolean.TRUE;
	}
}
