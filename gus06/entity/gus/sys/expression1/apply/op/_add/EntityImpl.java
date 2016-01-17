package gus06.entity.gus.sys.expression1.apply.op._add;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T, R {

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
		
		if(obj instanceof Number) return new T1((Number) obj);
		if(obj instanceof String) return new T2((String) obj);
		if(obj instanceof List) return new T3((List) obj);
		if(obj instanceof Set) return new T4((Set) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("input")) return new Class[]{
			Integer.class,Double.class,Float.class,Long.class,
			String.class,List.class,Set.class};
			
		if(key.equals("output")) return new Class[]{T.class};
		
		if(key.equals("keys")) return new String[]{"input","output"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	private class T1 implements T
	{
		private Number value;
		public T1(Number value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return add(value,toNumber(obj));}
	}
	
	
	private Object add(Number n1, Number n2) throws Exception
	{
		if(n1 instanceof Integer && n2 instanceof Integer)
			return new Integer(n1.intValue() + n2.intValue());
		return new Double(n1.doubleValue() + n2.doubleValue());
	}
	
	
	private Number toNumber(Object obj) throws Exception
	{return (Number) findNumber.t(obj);}
	
	
	
	
	private class T2 implements T
	{
		private String value;
		public T2(String value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return value+obj;}
	}
	
	
	private class T3 implements T
	{
		private List value;
		public T3(List value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			List l = new ArrayList(value);
			l.add(obj);
			return l; 
		}
	}
	
	
	private class T4 implements T
	{
		private Set value;
		public T4(Set value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			Set l = new HashSet(value);
			l.add(obj);
			return l; 
		}
	}
}
