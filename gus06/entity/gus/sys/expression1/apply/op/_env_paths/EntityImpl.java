package gus06.entity.gus.sys.expression1.apply.op._env_paths;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170312";}

	public static final String T = "constant";


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.system.env.path.files");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return perform.g();
	}
}
