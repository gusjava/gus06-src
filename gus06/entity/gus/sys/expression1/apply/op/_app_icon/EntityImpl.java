package gus06.entity.gus.sys.expression1.apply.op._app_icon;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161003";}


	private Service provider;

	public EntityImpl() throws Exception
	{
		provider = Outside.service(this,"gus.icon.provider");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return provider.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
