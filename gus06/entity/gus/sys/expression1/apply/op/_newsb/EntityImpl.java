package gus06.entity.gus.sys.expression1.apply.op._newsb;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160408";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj instanceof String) return new StringBuffer((String) obj);
		
		return new StringBuffer();
	}
}
