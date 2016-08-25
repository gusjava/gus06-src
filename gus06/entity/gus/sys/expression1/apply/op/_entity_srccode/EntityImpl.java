package gus06.entity.gus.sys.expression1.apply.op._entity_srccode;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160517";}
	

	private Service findSrc;


	public EntityImpl() throws Exception
	{
		findSrc = Outside.service(this,"gus.app.jarfile.entity.findsrc");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return findSrc.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
