package gus06.entity.gus.sys.expression1.apply.op._st;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}



	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return new F_false();
		
		if(obj instanceof String) return new F1((String) obj);
		if(obj instanceof URL) return new F1(((URL) obj).toString());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String s;
		public F1(String s) {this.s = s;}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = (String) obj;
			return s.startsWith(s0);
		}
	}
	
	private class F_false implements F
	{
		public boolean f(Object obj) throws Exception {return false;}
	}
}
