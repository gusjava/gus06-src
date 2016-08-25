package gus06.entity.gus.sys.expression1.apply.op._xpr_varnumber;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160809";}

	private Service getVars;
	
	public EntityImpl() throws Exception
	{
		getVars = Outside.service(this,"gus.sys.parser3.tool.getvars");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return count(obj);
		if(obj instanceof List) return count(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Integer count(Object exp) throws Exception
	{
		Set vars = (Set) getVars.t(exp);
		return new Integer(vars.size());
	}
}
