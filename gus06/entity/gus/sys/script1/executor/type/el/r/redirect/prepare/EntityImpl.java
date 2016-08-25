package gus06.entity.gus.sys.script1.executor.type.el.r.redirect.prepare;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.io.PrintStream;
import java.io.OutputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160415";}


	private Service deepPut;
	
	public EntityImpl() throws Exception
	{
		deepPut = Outside.service(this,"gus.map.deep.put.replace");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map pool = (Map) o[1];
		
		if(value instanceof P) return value;
		if(value instanceof File) return value;
		if(value instanceof StringBuffer) return value;
		if(value instanceof StringBuilder) return value;
		if(value instanceof PrintStream) return value;
		if(value instanceof OutputStream) return value;
		
		if(value instanceof String) return new Wrap1(pool,(String) value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class Wrap1 implements P, E
	{
		private Map map;
		private String key;
		private StringBuffer sb;
		
		public Wrap1(Map map, String key)
		{
			this.map = map;
			this.key = key;
			sb = new StringBuffer();
		}
		
		public void p(Object obj) throws Exception
		{sb.append(obj);}
		
		public void e() throws Exception
		{deepPut.p(new Object[]{map,key,sb.toString()});}
	}
}
