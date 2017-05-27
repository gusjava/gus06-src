package gus06.entity.gus.sys.expression1.apply.op._toservice_ign;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170525";}


	private Service wrapper;
	
	public EntityImpl() throws Exception
	{
		wrapper = Outside.service(this,"gus.service.wrapper1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return wrapper.t(obj);
	}
}
