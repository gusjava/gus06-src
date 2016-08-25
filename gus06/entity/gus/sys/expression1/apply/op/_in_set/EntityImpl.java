package gus06.entity.gus.sys.expression1.apply.op._in_set;

import gus06.framework.*;
import java.util.Collections;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160721";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		return Collections.singleton(obj);
	}
}
