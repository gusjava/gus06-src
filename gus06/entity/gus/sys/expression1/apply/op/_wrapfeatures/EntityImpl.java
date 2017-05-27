package gus06.entity.gus.sys.expression1.apply.op._wrapfeatures;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161212";}


	private Service builder;
	
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.feature.wrap.builder1");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Map) return builder.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
