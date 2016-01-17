package gus06.entity.gus.sys.expression1.apply.op._not;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


	private Service perform;
	
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.inv");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Boolean) return perform.t(obj);
		if(obj instanceof F) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
