package gus06.entity.gus.sys.expression1.apply.op._to_pbe_de;

import gus06.framework.*;
import javax.crypto.SecretKey;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}


	private Service builder;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.crypto.pbe.object.decrypt");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return builder.t(obj);
		if(obj instanceof SecretKey) return builder.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
