package gus06.entity.gus.sys.expression1.apply.op2.string;

import gus06.framework.*;
import java.util.Map;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	private Service pWrap;
	
	public EntityImpl() throws Exception
	{
		pWrap = Outside.service(this,"gus.feature.wrap.pobj.e");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		return new T1((String) obj);
	}
	
	
	private class T1 implements T
	{
		private String k;
		
		public T1(String k)
		{
			this.k = k.startsWith("~") ? k.substring(1) : k;
		}
		
		
		public Object t(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			obj = o[0];
		
			if(obj==null) return null;
			
			if(obj instanceof Map) return elementAt((Map) obj,k);
			if(obj instanceof Set) return contains((Set) obj,k);
			if(obj instanceof Object[]) return findByValue((Object[]) obj,k);
			if(obj instanceof File[]) return findByValue((File[]) obj,k);
			
			if(obj instanceof R) return retrieve((R) obj,k);
			if(obj instanceof T) return retrieve((T) obj,k);
			if(obj instanceof F) return retrieve((F) obj,k);
			if(obj instanceof P) return retrieve((P) obj,k);
			
			throw new Exception("Invalid operator ["+k+"] for object "+obj.getClass().getName());
		}
	}
	
	
	
	private Object elementAt(Map m, String k)
	{
		if(m.containsKey(k)) return m.get(k);
		return null;
	}
	
	private Boolean contains(Set s, String k)
	{
		if(s.contains(k)) return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	private Object findByValue(Object[] a, String k)
	{
		for(Object o:a)
		if(o.toString().equals(k)) return o;
		return null;
	}
	
	private Object findByValue(File[] a, String k)
	{
		for(File f:a)
		if(f.getName().equals(k)) return f;
		return null;
	}
	
	private Object retrieve(R r, String k) throws Exception
	{return r.r(k);}
	
	private Object retrieve(T t, String k) throws Exception
	{return t.t(k);}
	
	private Object retrieve(F f, String k) throws Exception
	{return new Boolean(f.f(k));}
	
	private Object retrieve(P p, String k) throws Exception
	{return pWrap.t(new Object[]{p,k});}
}