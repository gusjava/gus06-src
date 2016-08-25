package gus06.entity.gus.sys.expression1.apply.op._cosh;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151113";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Double) return new Double(Math.cosh(_d(obj)));
		if(obj instanceof Integer) return new Double(Math.cosh(_d(obj)));
		if(obj instanceof Float) return new Double(Math.cosh(_d(obj)));
		if(obj instanceof Long) return new Double(Math.cosh(_d(obj)));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private double _d(Object obj)
	{return Double.parseDouble(""+obj);}
}
