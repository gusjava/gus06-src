package gus06.entity.gus.sys.expression1.apply.op._once;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170320";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.app.persister1.once");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return check(obj);
		if(obj instanceof Number) return check(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Boolean check(Object obj) throws Exception
	{
		return new Boolean(perform.f(getClass().getName()+"_"+obj));
	}
}
