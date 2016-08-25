package gus06.entity.gus.sys.expression1.apply.op._int3_validdate;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160616";}


	private Service check;
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.time.date.int3.is.valid");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof int[]) return new Boolean(check.f(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
