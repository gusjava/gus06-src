package gus06.entity.gus.sys.expression1.apply.op._double;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return new Integer(toInt(obj)*2);
		if(obj instanceof Double) return new Double(toDouble(obj)*2);
		if(obj instanceof Float) return new Float(toFloat(obj)*2);
		if(obj instanceof Long) return new Long(toLong(obj)*2);
		
		if(obj instanceof String) return doubleString((String) obj);
		if(obj instanceof List) return doubleList((List) obj);
		if(obj instanceof E) return new E0((E) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
	
	private float toFloat(Object obj)
	{return Float.parseFloat(""+obj);}
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
	
	
	private String doubleString(String s)
	{return s+s;}
	
	
	private List doubleList(List l)
	{
		List l1 = new ArrayList();
		l1.addAll(l);
		l1.addAll(l);
		return l1;
	}
	
	
	private class E0 implements E
	{
		private E e;
		public E0(E e) {this.e = e;}
		
		public void e() throws Exception
		{e.e();e.e();}
	}
}
