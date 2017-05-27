package gus06.entity.gus.sys.expression1.apply.op._tocx;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151114";}


	private Service buildCx;
	
	public EntityImpl() throws Exception
	{
		buildCx = Outside.service(this,"gus.jdbc.connection.builder");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return buildCx.t(obj);
		if(obj instanceof String[]) return buildCx.t(obj);
		if(obj instanceof List) return buildCx.t(obj);
		if(obj instanceof Map) return buildCx.t(obj);
		if(obj instanceof G) return buildCx.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
