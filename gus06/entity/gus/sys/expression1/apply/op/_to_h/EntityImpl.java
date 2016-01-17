package gus06.entity.gus.sys.expression1.apply.op._to_h;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151113";}


	private Service builder;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder1.h");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof H) return value;
		
		if(value instanceof String)
			return builder.t(new Object[]{value,opMap});
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
}
