package gus06.entity.gus.sys.expression1.apply.op._replace;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new T1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private String line;
		public T1(String line) {this.line = line;}
		
		public Object t(Object obj) throws Exception
		{
			if(obj==null) return replace(line,"null");
			
			if(obj instanceof Boolean) return replace(line,""+obj);
			if(obj instanceof Number) return replace(line,""+obj);
			if(obj instanceof String) return replace(line,""+obj);
			
			if(obj instanceof Object[]) return replace(line,(Object[]) obj);
			if(obj instanceof double[]) return replace(line,(double[]) obj);
			if(obj instanceof int[]) return replace(line,(int[]) obj);
			if(obj instanceof long[]) return replace(line,(long[]) obj);
			if(obj instanceof float[]) return replace(line,(float[]) obj);
			
			if(obj instanceof List) return replace(line,(List) obj);
			if(obj instanceof Map) return replace(line,(Map) obj);
			
			throw new Exception("Invalid data type: "+obj.getClass().getName());
		}
	}
	
	
	private String replace(String line, String s)
	{return line.replace("*",s);}
	
	private String replace(String line, Object[] t)
	{
		for(int i=0;i<t.length;i++)
			line = line.replace("<"+i+">",""+t[i]);
		return line;
	}
	
	private String replace(String line, double[] t)
	{
		for(int i=0;i<t.length;i++)
			line = line.replace("<"+i+">",""+t[i]);
		return line;
	}
	
	private String replace(String line, int[] t)
	{
		for(int i=0;i<t.length;i++)
			line = line.replace("<"+i+">",""+t[i]);
		return line;
	}
	
	private String replace(String line, long[] t)
	{
		for(int i=0;i<t.length;i++)
			line = line.replace("<"+i+">",""+t[i]);
		return line;
	}
	
	private String replace(String line, float[] t)
	{
		for(int i=0;i<t.length;i++)
			line = line.replace("<"+i+">",""+t[i]);
		return line;
	}
	
	private String replace(String line, List l)
	{
		for(int i=0;i<l.size();i++)
			line = line.replace("<"+i+">",""+l.get(i));
		return line;
	}
	
	private String replace(String line, Map m)
	{
		Iterator it = m.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			line = line.replace(key,""+m.get(key));
		}
		return line;
	}
}
