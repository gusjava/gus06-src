package gus06.entity.gus.sys.expression1.apply.op._d;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151202";}
	

	private Service desc;
		
	public EntityImpl() throws Exception
	{
		desc = Outside.service(this,"gus.tostring.desc");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		System.out.println(desc.t(obj));
		return obj;
	}
}
