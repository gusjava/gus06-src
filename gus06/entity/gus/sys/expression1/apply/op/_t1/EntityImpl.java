package gus06.entity.gus.sys.expression1.apply.op._t1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151116";}

	public static final String T = "constant";
	
	
	public Object t(Object obj) throws Exception
	{
		return new T0();
	}
	
	private class T0 implements T
	{
		public Object t(Object obj) throws Exception
		{return obj;}
	}
}