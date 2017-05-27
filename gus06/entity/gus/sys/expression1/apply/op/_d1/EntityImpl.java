package gus06.entity.gus.sys.expression1.apply.op._d1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161119";}
	

	private Service desc;
	private Service now;
		
	public EntityImpl() throws Exception
	{
		desc = Outside.service(this,"gus.tostring.desc");
		now = Outside.service(this,"gus.time.now");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		System.out.println(now.g()+":"+desc.t(obj));
		return obj;
	}
}
