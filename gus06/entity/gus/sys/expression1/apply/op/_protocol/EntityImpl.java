package gus06.entity.gus.sys.expression1.apply.op._protocol;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170113";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof URL) return ((URL) obj).getProtocol();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
