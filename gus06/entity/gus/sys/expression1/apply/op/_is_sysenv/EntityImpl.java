package gus06.entity.gus.sys.expression1.apply.op._is_sysenv;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151123";}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		if(!(obj instanceof String)) return Boolean.FALSE;
		
		return new Boolean(System.getenv().containsKey((String) obj));
	}
}
