package gus06.entity.gus.sys.expression1.apply.op._co_i;

import gus06.framework.*;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}

	private Service readText;
	
	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.generic");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return new F_false();
		if(obj instanceof String) return new F1((String) obj);
		if(obj instanceof File) return new F1((String) readText.t(obj));
		if(obj instanceof Collection) return new F2((Collection) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String s;
		public F1(String s) {this.s = s.toLowerCase();}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = ((String) obj).toLowerCase();
			return s.contains(s0);
		}
	}
	
	private class F2 implements F
	{
		private Collection c;
		public F2(Collection c) {this.c = c;}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = ((String) obj).toLowerCase();
			Iterator it = c.iterator();
			while(it.hasNext())
			{
				String el = (String) it.next();
				if(s0.equals(el.toLowerCase())) return true;
			}
			return false;
		}
	}
	
	private class F_false implements F
	{
		public boolean f(Object obj) throws Exception {return false;}
	}
}
