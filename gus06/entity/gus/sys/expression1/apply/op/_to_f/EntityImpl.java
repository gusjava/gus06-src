package gus06.entity.gus.sys.expression1.apply.op._to_f;

import gus06.framework.*;
import java.util.Map;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151113";}


	private Service builder;
	private Service mapToF;
	private Service colToF;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder1.f");
		mapToF = Outside.service(this,"gus.convert.maptof");
		colToF = Outside.service(this,"gus.convert.coltof");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof F) return value;
		if(value instanceof Map) return mapToF.t(value);
		if(value instanceof Collection) return colToF.t(value);
		
		if(value instanceof String)
			return builder.t(new Object[]{value,opMap});
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
}
