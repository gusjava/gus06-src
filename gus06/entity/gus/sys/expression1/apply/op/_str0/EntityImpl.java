package gus06.entity.gus.sys.expression1.apply.op._str0;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160225";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return obj!=null ? obj : "";
	}
}
