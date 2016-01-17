package gus06.entity.gus.sys.expression1.apply.op._minvalue;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Integer) return new Integer(Integer.MIN_VALUE);
		if(obj instanceof Double) return new Double(Double.MIN_VALUE);
		if(obj instanceof Long) return new Long(Long.MIN_VALUE);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
