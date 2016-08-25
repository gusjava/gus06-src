package gus06.entity.gus.sys.expression1.apply.op2.string;

import gus06.framework.*;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	private Service pWrap;
	private Service ruleToIndex;
	
	public EntityImpl() throws Exception
	{
		pWrap = Outside.service(this,"gus.feature.wrap.pobj.e");
		ruleToIndex = Outside.service(this,"gus.list.ruletoindex");
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
			
			if(obj instanceof List) return findByValue((List) obj,k);
			if(obj instanceof String) return findByValue((String) obj,k);
			if(obj instanceof File[]) return findByValue((File[]) obj,k);
			if(obj instanceof Object[]) return findByValue((Object[]) obj,k);
			
			if(obj instanceof boolean[]) return findByValue((boolean[]) obj,k);
			if(obj instanceof byte[]) return findByValue((byte[]) obj,k);
			if(obj instanceof int[]) return findByValue((int[]) obj,k);
			if(obj instanceof double[]) return findByValue((double[]) obj,k);
			if(obj instanceof float[]) return findByValue((float[]) obj,k);
			if(obj instanceof long[]) return findByValue((long[]) obj,k);
			
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
	
	
	
	
	private Object findByValue(List l, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{l,k});
		return index==null ? null : l.get(index.intValue());
	}
	
	private Object findByValue(String s, String k)
	{
		if(k.equals("first")) return s.length()==0 ? null : s.charAt(0);
		if(k.equals("last")) return s.length()==0 ? null : s.charAt(s.length()-1);
		if(k.equals("random")) return s.length()==0 ? null : s.charAt(random(s.length()));
		
		return null;
	}
	
	private Object findByValue(File[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : a[0];
		if(k.equals("last")) return a.length==0 ? null : a[a.length-1];
		if(k.equals("random")) return a.length==0 ? null : a[random(a.length)];
		
		for(File f:a)
		if(f.getName().equals(k)) return f;
		return null;
	}
	
	private Object findByValue(Object[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : a[0];
		if(k.equals("last")) return a.length==0 ? null : a[a.length-1];
		if(k.equals("random")) return a.length==0 ? null : a[random(a.length)];
		
		return null;
	}
	
	private Object findByValue(boolean[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : new Boolean(a[0]);
		if(k.equals("last")) return a.length==0 ? null : new Boolean(a[a.length-1]);
		if(k.equals("random")) return a.length==0 ? null : new Boolean(a[random(a.length)]);
		
		return null;
	}
	
	private Object findByValue(byte[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : new Byte(a[0]);
		if(k.equals("last")) return a.length==0 ? null : new Byte(a[a.length-1]);
		if(k.equals("random")) return a.length==0 ? null : new Byte(a[random(a.length)]);
		
		return null;
	}
	
	private Object findByValue(int[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : new Integer(a[0]);
		if(k.equals("last")) return a.length==0 ? null : new Integer(a[a.length-1]);
		if(k.equals("random")) return a.length==0 ? null : new Integer(a[random(a.length)]);
		
		return null;
	}
	
	private Object findByValue(double[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : new Double(a[0]);
		if(k.equals("last")) return a.length==0 ? null : new Double(a[a.length-1]);
		if(k.equals("random")) return a.length==0 ? null : new Double(a[random(a.length)]);
		
		return null;
	}
	
	private Object findByValue(float[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : new Float(a[0]);
		if(k.equals("last")) return a.length==0 ? null : new Float(a[a.length-1]);
		if(k.equals("random")) return a.length==0 ? null : new Float(a[random(a.length)]);
		
		return null;
	}
	
	private Object findByValue(long[] a, String k)
	{
		if(k.equals("first")) return a.length==0 ? null : new Long(a[0]);
		if(k.equals("last")) return a.length==0 ? null : new Long(a[a.length-1]);
		if(k.equals("random")) return a.length==0 ? null : new Long(a[random(a.length)]);
		
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
	
	
	
	
	
	
	private int random(int n)
	{return (int) (Math.random()*n);}
}