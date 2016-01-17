package gus06.entity.gus.sys.expression1.apply.op._toint;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new Integer((String) obj);
		if(obj instanceof Boolean) return new Integer(((Boolean) obj)?1:0);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
