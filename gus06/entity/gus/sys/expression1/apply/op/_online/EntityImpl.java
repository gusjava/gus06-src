package gus06.entity.gus.sys.expression1.apply.op._online;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170404";}

	public static final String T = "constant";


	private Service check;
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.web.check.online");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return new Boolean(check.f(null));
	}
}
