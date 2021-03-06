package gus06.entity.gus.sys.expression1.apply.op._is_url;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		return new Boolean(obj instanceof URL);
	}
}
