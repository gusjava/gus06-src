package gus06.entity.gus.sys.expression1.apply.op._rel_fibonacci;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170116";}
	
	public static final String T = "constant";


	private Service build;

	public EntityImpl() throws Exception
	{
		build = Outside.service(this,"gus.math.relation.recurrence.f.fibonacci");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return build.g();
	}
}
