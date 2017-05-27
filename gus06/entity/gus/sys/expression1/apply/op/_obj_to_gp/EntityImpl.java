package gus06.entity.gus.sys.expression1.apply.op._obj_to_gp;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.buildholder.obj.gp");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return perform.t(obj);
	}
}
