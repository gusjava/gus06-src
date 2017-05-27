package gus06.entity.gus.data.string.tool.replacebuilder;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170319";}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		T t = (T) o[0];
		Object data = o[1];
		
		if(data==null) return null;
		
		if(data instanceof String) return new T1(t,(String) data);
		if(data instanceof String[]) return handleArray(t,(String[]) data);
		if(data instanceof List) return handleArray(t,listToArray((List) data));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private T t;
		private String line;
		
		public T1(T t, String line)
		{
			this.t = t;
			this.line = line;
		}
		
		public Object t(Object obj) throws Exception
		{return handleLine(t, line, obj);}
	}
	
	
	
	private Object handleLine(T t, String line, Object obj) throws Exception
	{
		String[] arr = toArray2(obj);
		if(arr!=null) return replace(t,line,arr[0],arr[1]);
		
		return new T2(t,line,toString_(obj));
	}
	
	
	private Object handleArray(T t, String[] arr) throws Exception
	{
		if(arr.length==3) return replace(t,arr[0],arr[1],arr[2]);
		if(arr.length==2) return new T2(t,arr[0],arr[1]);
		
		throw new Exception("Invalid array length: "+arr.length);
	}
	
	
	
	private class T2 implements T
	{
		private T t;
		private String line;
		private String s1;
		
		public T2(T t, String line, String s1)
		{
			this.t = t;
			this.line = line;
			this.s1 = s1;
		}
		
		public Object t(Object obj) throws Exception
		{return replace(t,line,s1,toString_(obj));}
	}
	
	
	
	
	private String toString_(Object obj) throws Exception
	{
		if(obj instanceof Boolean) return ""+obj;
		if(obj instanceof Number) return ""+obj;
		if(obj instanceof String) return ""+obj;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String[] toArray2(Object obj) throws Exception
	{
		if(obj instanceof String[])
		{
			String[] arr = (String[]) obj;
			if(arr.length!=2) throw new Exception("Invalid array length: "+arr.length);
			return arr;
		}
		if(obj instanceof List)
		{
			List list = (List) obj;
			if(list.size()!=2) throw new Exception("Invalid list size: "+list.size());
			
			String el1 = toString_(list.get(0));
			String el2 = toString_(list.get(1));
			return new String[]{el1,el2};
		}
		return null;
	}
	
	
	
	private String[] listToArray(List list) throws Exception
	{
		String[] arr = new String[list.size()];
		for(int i=0;i<arr.length;i++) arr[i] = toString_(list.get(i));
		return arr;
	}
	
	
	
	private String replace(T t, String line, String s1, String s2) throws Exception
	{return (String) t.t(new String[]{line,s1,s2});}
}