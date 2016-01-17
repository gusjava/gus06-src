package gus06.entity.gus.sys.parser3.resolver1.op.unary.not;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = (Map) o[0];
		T t = (T) o[1];
		
		Object value = t.t(tag);
		if(value==null) return null;

		if(value.equals(Boolean.TRUE)) return Boolean.FALSE;
		if(value.equals(Boolean.FALSE)) return Boolean.TRUE;
		
		throw new Exception("Invalid value type for operator: "+value.getClass().getName());
	}
}
