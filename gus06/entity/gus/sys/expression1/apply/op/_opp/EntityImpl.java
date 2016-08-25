package gus06.entity.gus.sys.expression1.apply.op._opp;

import gus06.framework.*;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.opp");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof H) return perform.t(obj);
		if(obj instanceof Set) return perform.t(obj);
		if(obj instanceof List) return perform.t(obj);
		
		if(obj instanceof Integer) return perform.t(obj);
		if(obj instanceof Double) return perform.t(obj);
		if(obj instanceof Float) return perform.t(obj);
		if(obj instanceof Long) return perform.t(obj);
		
		if(obj instanceof int[]) return perform.t(obj);
		if(obj instanceof double[]) return perform.t(obj);
		if(obj instanceof float[]) return perform.t(obj);
		if(obj instanceof long[]) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
