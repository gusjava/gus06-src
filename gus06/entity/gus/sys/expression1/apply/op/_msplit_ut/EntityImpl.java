package gus06.entity.gus.sys.expression1.apply.op._msplit_ut;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170119";}
	
	public static final String GLUE1 = "_";
	public static final String GLUE2 = "\t";


	private Service perform;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.msplit");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(new Object[]{obj,GLUE1,GLUE2});
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
