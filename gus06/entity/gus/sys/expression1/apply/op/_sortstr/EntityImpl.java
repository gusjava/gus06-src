package gus06.entity.gus.sys.expression1.apply.op._sortstr;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170111";}
	
	
	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.sortstring");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		return perform.t(obj);
	}
}
