package gus06.entity.gus.sys.expression1.apply.op._ft;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151116";}
	
	
	public Object t(Object obj) throws Exception
	{
		return new F0();
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{Object.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	private class F0 implements F
	{
		public boolean f(Object obj) throws Exception
		{return true;}
	}
}