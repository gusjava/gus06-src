package gus06.entity.gus.sys.expression1.apply.op._ff;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151116";}

	public static final String T = "constant";
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new F0();
	}
	
	private class F0 implements F
	{
		public boolean f(Object obj) throws Exception
		{return false;}
	}
}