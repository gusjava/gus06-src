package gus06.entity.gus.sys.expression1.apply.op._apperrors;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}

	public static final String T = "constant";
	

	private Object errors;
		
	public EntityImpl() throws Exception
	{
		errors = Outside.resource(this,"errors");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return errors;
	}
}
