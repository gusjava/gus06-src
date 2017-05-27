package gus06.entity.gus.sys.expression1.apply.op._count;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170118";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.count");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof List) return perform.t(value);
		if(value instanceof Set) return perform.t(value);
		if(value instanceof Object[]) return perform.t(value);
		if(value instanceof int[]) return perform.t(value);
		if(value instanceof short[]) return perform.t(value);
		if(value instanceof long[]) return perform.t(value);
		if(value instanceof double[]) return perform.t(value);
		if(value instanceof float[]) return perform.t(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
}
