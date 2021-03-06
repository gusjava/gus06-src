package gus06.entity.gus.sys.expression1.apply.op._norm_u;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160203";}


	private Service norm;
	
	public EntityImpl() throws Exception
	{
		norm = Outside.service(this,"gus.string.transform.normalize.diacritics.lower.underscore");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return norm.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
