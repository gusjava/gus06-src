package gus06.entity.gus.sys.expression1.apply.op._new;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Class) return ((Class) obj).newInstance();
		if(obj instanceof String) return Class.forName((String) obj).newInstance();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}