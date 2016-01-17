package gus06.entity.gus.sys.parser3.resolver1.op.unary.apply;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	private Service prepare;

	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = (Map) o[0];
		T t = (T) o[1];
		
		Object value = t.t(tag);
		if(value==null) throw new Exception("Invalid value type for operator: null");

		if(value instanceof String)
		return apply((String) value,t);
		
		throw new Exception("Invalid value type for operator: "+value.getClass().getName());
	}
	
	
	private Object apply(String value, T t) throws Exception
	{
		List list = (List) prepare.t(value);
		return t.t(list);
	}
}
