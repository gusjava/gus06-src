package gus06.entity.gus.sys.expression1.apply.op._n;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		return obj.toString()+"\n";
	}
}
