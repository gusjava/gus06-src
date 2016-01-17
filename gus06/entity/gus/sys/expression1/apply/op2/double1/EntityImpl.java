package gus06.entity.gus.sys.expression1.apply.op2.double1;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151116";}
	
	
	private Service pWrap;
	
	public EntityImpl() throws Exception
	{
		pWrap = Outside.service(this,"gus.feature.wrap.pobj.e");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		String op = (String) obj;
		double number = Double.parseDouble(op);
		return new T1(number);
	}
	
	
	private class T1 implements T
	{
		private double number;
		public T1(double number) {this.number = number;}
		
		public Object t(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			obj = o[0];
		
			if(obj==null) return null;
			
			if(obj instanceof Integer) return new Boolean(toInt(obj)==number);
			if(obj instanceof Double) return new Boolean(toDouble(obj)==number);
			
			if(obj instanceof Map) return elementAt((Map) obj,number);
			if(obj instanceof Set) return contains((Set) obj,number);
			
			if(obj instanceof R) return retrieve((R) obj,""+number);
			if(obj instanceof T) return retrieve((T) obj,""+number);
			if(obj instanceof F) return retrieve((F) obj,""+number);
			if(obj instanceof H) return retrieve((H) obj,number);
			if(obj instanceof P) return retrieve((P) obj,""+number);
			
			throw new Exception("Invalid operator  ["+number+"] for object "+obj.getClass().getName());
		}
	}
	
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
	
	
	
	
	
	private Object elementAt(Map m, double n)
	{
		if(m.containsKey(new Double(n))) return m.get(new Double(n));
		if(m.containsKey(""+n)) return m.get(""+n);
		return null;
	}
	
	
	
	private Boolean contains(Set s, double n)
	{
		if(s.contains(new Double(n))) return Boolean.TRUE;
		if(s.contains(""+n)) return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	
	
	
	
	private Object retrieve(R r, String k) throws Exception
	{return r.r(k);}
	
	private Object retrieve(T t, Object k) throws Exception
	{return t.t(k);}
	
	private Object retrieve(F f, Object k) throws Exception
	{return new Boolean(f.f(k));}
	
	private Object retrieve(H h, double v) throws Exception
	{return new Double(h.h(v));}
	
	private Object retrieve(P p, Object k) throws Exception
	{return pWrap.t(new Object[]{p,k});}
}