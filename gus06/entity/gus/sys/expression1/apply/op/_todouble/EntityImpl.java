package gus06.entity.gus.sys.expression1.apply.op._todouble;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new Double((String) obj);
		if(obj instanceof Integer) return new Double((Integer) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
