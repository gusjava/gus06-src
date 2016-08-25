package gus06.entity.gus.sys.expression1.apply.op._xpr_analyze;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160810";}

	private Service prepare;
	private Service analyze;
	
	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
		analyze = Outside.service(this,"gus.sys.parser3.analyzer1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return analyze.t(prepare.t(obj));
		if(obj instanceof List) return analyze.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
