package gus06.entity.gus.sys.expression1.apply.op._script_to_h;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160504";}


	private Service builder;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.script1.build.h");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof String) return builder.t(obj);
		if(value instanceof File) return builder.t(obj);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
}
