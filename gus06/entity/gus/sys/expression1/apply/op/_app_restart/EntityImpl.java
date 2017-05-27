package gus06.entity.gus.sys.expression1.apply.op._app_restart;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170410";}

	public static final String T = "constant";


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.app.restart");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new E1();
	}
	
	private class E1 implements E
	{
		public void e() throws Exception
		{perform.e();}
	}
}
