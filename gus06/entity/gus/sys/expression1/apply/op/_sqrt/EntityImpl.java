package gus06.entity.gus.sys.expression1.apply.op._sqrt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Integer) return new Double(Math.sqrt(((Integer)obj).intValue()));
		if(obj instanceof Double) return new Double(Math.sqrt(((Double)obj).doubleValue()));
		if(obj instanceof Float) return new Double(Math.sqrt(((Float)obj).floatValue()));
		if(obj instanceof Long) return new Double(Math.sqrt(((Long)obj).longValue()));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
