package gus06.entity.gus.sys.expression1.apply.op._rem;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	private Service findNumber;
	
	public EntityImpl() throws Exception
	{findNumber = Outside.service(this,"gus.find.number");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Number) return new T1((Number)obj);
		if(obj instanceof String) return new T2((String)obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	
	
	private class T1 implements T
	{
		private Number value;
		public T1(Number value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			if(obj==null) return value;
			return rem(value,toNumber(obj));
		}
	}
	
	private class T2 implements T
	{
		private String value;
		public T2(String value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			if(obj==null) return value;
			return rem(value,(String) obj);
		}
	}
	
	
	
	private Object rem(Number n1, Number n2) throws Exception
	{
		if(n1 instanceof Integer && n2 instanceof Integer)
			return new Integer(n1.intValue() - n2.intValue());
		return new Double(n1.doubleValue() - n2.doubleValue());
	}
	
	private Object rem(String s1, String s2) throws Exception
	{return s1.replace(s2,"");}
	
	
	
	private Number toNumber(Object obj) throws Exception
	{return (Number) findNumber.t(obj);}
}
