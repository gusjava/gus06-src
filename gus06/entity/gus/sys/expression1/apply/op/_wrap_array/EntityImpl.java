package gus06.entity.gus.sys.expression1.apply.op._wrap_array;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161215";}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) throw new Exception("Enable to wrap null inside List");
		
		return new Object[]{obj};
	}
}
