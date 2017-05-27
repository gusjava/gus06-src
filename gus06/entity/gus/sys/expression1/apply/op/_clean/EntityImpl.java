package gus06.entity.gus.sys.expression1.apply.op._clean;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170201";}


	private Service perform;
	private Service findList;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.clean");
		findList = Outside.service(this,"gus.find.list");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof List) return perform.t(obj);
		if(obj instanceof Set) return perform.t(obj);
		if(obj instanceof Map) return perform.t(obj);
		if(obj instanceof String[]) return perform.t(findList.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
