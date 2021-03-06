package gus06.entity.gus.sys.expression1.apply.op._tolong;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Number) return new Long(((Number) obj).longValue());
		if(obj instanceof String) return new Long((String) obj);
		if(obj instanceof Date) return new Long(((Date) obj).getTime());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
