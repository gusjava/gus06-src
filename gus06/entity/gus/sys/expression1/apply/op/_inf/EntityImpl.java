package gus06.entity.gus.sys.expression1.apply.op._inf;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Integer) return new F_inf(toInt(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{Integer.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	
	private class F_inf implements F
	{
		private int value;
		public F_inf(int value) {this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{return value < toInt(obj);}
	}
}
