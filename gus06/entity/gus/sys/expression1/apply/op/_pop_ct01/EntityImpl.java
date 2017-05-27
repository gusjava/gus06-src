package gus06.entity.gus.sys.expression1.apply.op._pop_ct01;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170419";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.pop.strict01");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map)		return perform.t(obj);
		if(obj instanceof Collection)	return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
}
