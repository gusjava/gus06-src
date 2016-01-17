package gus06.entity.gus.sys.expression1.apply.op._pbe3strde;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}


	private Service builder;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.crypto.pbe2.string.decrypt");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof String) return builder.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
