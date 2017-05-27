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
		pWrap = Outside.service(this,"gus.feature.wrap.po.e");
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
			
			try
			{
				if(obj instanceof Map) return elementAt((Map) obj,k);
				if(obj instanceof Set) return contains((Set) obj,k);
				if(obj instanceof File) return child((File) obj,k);
				
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
				if(obj instanceof short[]) return findByValue((long[]) obj,k);
				if(obj instanceof char[]) return findByValue((long[]) obj,k);
				
				if(obj instanceof R) return retrieve((R) obj,k);
				if(obj instanceof T) return retrieve((T) obj,k);
				if(obj instanceof F) return retrieve((F) obj,k);
				if(obj instanceof P) return retrieve((P) obj,k);
				
				throw new Exception("Unsupported data type: "+obj.getClass().getName());
			}
			catch(Exception e)
			{
				String message = "Failed to apply operator ["+k+"] on object's type "+obj.getClass().getName();
				throw new Exception(message,e);
			}
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
	
	private File child(File dir, String k)
	{
		return new File(dir,k);
	}
	
	
	
	
	private Object findByValue(List l, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{l,k});
		return index==null ? null : l.get(index.intValue());
	}
	
	private Object findByValue(String s, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{s,k});
		return index==null ? null : s.charAt(index.intValue());
	}
	
	private Object findByValue(File[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		if(index!=null) return a[index.intValue()];
		
		for(File f:a) if(f.getName().equals(k)) return f;
		return null;
	}
	
	private Object findByValue(Object[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : a[index.intValue()];
	}
	
	private Object findByValue(boolean[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Boolean(a[index.intValue()]);
	}
	
	private Object findByValue(byte[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Byte(a[index.intValue()]);
	}
	
	private Object findByValue(int[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Integer(a[index.intValue()]);
	}
	
	private Object findByValue(double[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Double(a[index.intValue()]);
	}
	
	private Object findByValue(float[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Float(a[index.intValue()]);
	}
	
	private Object findByValue(long[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Long(a[index.intValue()]);
	}
	
	private Object findByValue(short[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : new Short(a[index.intValue()]);
	}
	
	private Object findByValue(char[] a, String k) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{a,k});
		return index==null ? null : ""+a[index.intValue()];
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