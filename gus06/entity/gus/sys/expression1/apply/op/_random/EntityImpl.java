package gus06.entity.gus.sys.expression1.apply.op._random;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.random");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return perform.t(obj);
		if(obj instanceof Boolean) return perform.t(obj);
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof List) return perform.t(obj);
		if(obj instanceof Set) return perform.t(obj);
		if(obj instanceof Map) return perform.t(obj);
		if(obj instanceof Object[]) perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
