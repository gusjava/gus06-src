package gus06.entity.gus.data.perform.collectvalue3;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170326";}
	
	
	private Service performMap;
	
	public EntityImpl() throws Exception
	{
		performMap = Outside.service(this,"gus.map.value.collect3");
	}
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Map) 	{performMap.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Map) return performMap.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
