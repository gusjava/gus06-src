package gus06.entity.gus.sys.expression1.apply.op._w1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160910";}


	private Service wrap;
	
	public EntityImpl() throws Exception
	{
		wrap = Outside.service(this,"gus.reflection.wrap.class1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		return wrap.t(obj);
	}
}
