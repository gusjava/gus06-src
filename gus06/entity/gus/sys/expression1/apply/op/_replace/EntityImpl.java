package gus06.entity.gus.sys.expression1.apply.op._replace;

import gus06.framework.*;
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
			if(obj instanceof Boolean) return replace(line,""+obj);
			if(obj instanceof Number) return replace(line,""+obj);
			if(obj instanceof String) return replace(line,(String) obj);
			if(obj instanceof Map) return replace(line,(Map) obj);
			
			throw new Exception("Invalid data type: "+obj.getClass().getName());
		}
	}
	
	
	private String replace(String line, String s)
	{return line.replace("*",s);}
	
	
	
	private String replace(String line, Map m)
	{
		Iterator it = m.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = ""+m.get(key);
			
			line = line.replace(key,value);
		}
		return line;
	}
	
	
}
