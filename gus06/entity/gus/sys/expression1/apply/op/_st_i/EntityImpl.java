package gus06.entity.gus.sys.expression1.apply.op._st_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new F1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String s;
		public F1(String s) {this.s = s.toLowerCase();}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = ((String) obj).toLowerCase();
			return s.startsWith(s0);
		}
	}
}
