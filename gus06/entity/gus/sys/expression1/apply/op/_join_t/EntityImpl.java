package gus06.entity.gus.sys.expression1.apply.op._join_t;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160204";}

	public static final String GLUE = "\t";


	private Service perform;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.join");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String[]) return join(obj);
		if(obj instanceof List) return join(obj);
		if(obj instanceof Set) return join(obj);
		if(obj instanceof Map) return join(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object join(Object obj) throws Exception
	{return perform.t(new Object[]{obj,GLUE});}
}
