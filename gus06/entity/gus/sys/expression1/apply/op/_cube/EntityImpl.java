package gus06.entity.gus.sys.expression1.apply.op._cube;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer)
		{
			int n = toInt(obj);
			return new Integer(n*n*n);
		}
		if(obj instanceof Double)
		{
			double d = toDouble(obj);
			return new Double(d*d*d);
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return ((Integer) obj).intValue();}
	
	private double toDouble(Object obj)
	{return ((Double) obj).doubleValue();}
}
