package gus06.entity.gus.sys.expression1.apply.op._abs;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return new Integer(Math.abs(toInt(obj)));
		if(obj instanceof Double) return new Double(Math.abs(toDouble(obj)));
		if(obj instanceof Float) return new Float(Math.abs(toFloat(obj)));
		if(obj instanceof Long) return new Long(Math.abs(toLong(obj)));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("input")) return new Class[]{Integer.class,Double.class,Float.class,Long.class};
		if(key.equals("output")) return new Class[]{Integer.class,Double.class,Float.class,Long.class};
		
		if(key.equals("keys")) return new String[]{"input","output"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
	
	private float toFloat(Object obj)
	{return Float.parseFloat(""+obj);}
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
}
