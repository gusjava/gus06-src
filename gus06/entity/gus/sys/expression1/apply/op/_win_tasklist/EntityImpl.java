package gus06.entity.gus.sys.expression1.apply.op._win_tasklist;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170410";}

	public static final String T = "constant";


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.env.windows.find.tasklist");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return perform.g();
	}
}
