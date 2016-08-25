package gus06.entity.gus.sys.expression1.apply.op._empty;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service filter;
	
	public EntityImpl() throws Exception
	{
		filter = Outside.service(this,"gus.data.filter.isempty");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		return new Boolean(filter.f(obj));
	}
}
