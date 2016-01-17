package gus06.entity.gus.sys.expression1.apply.op._eq;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		return new F_eq(obj);
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{Object.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	private class F_eq implements F
	{
		private Object value;
		public F_eq(Object value) {this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{
			if(value instanceof Integer)
				return toInt(value) == toInt(obj);
			if(value instanceof Double)
				return toDouble(value) == toDouble(obj);
			if(value instanceof Long)
				return toLong(value) == toLong(obj);
			if(value instanceof Float)
				return toFloat(value) == toFloat(obj);
			
			return value.toString().equals(obj.toString());
		}
	}
	
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
	
	private float toFloat(Object obj)
	{return Float.parseFloat(""+obj);}
}
