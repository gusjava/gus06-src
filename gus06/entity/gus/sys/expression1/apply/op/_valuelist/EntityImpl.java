package gus06.entity.gus.sys.expression1.apply.op._valuelist;

import gus06.framework.*;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161019";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Map) return new ArrayList(((Map) obj).values());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
