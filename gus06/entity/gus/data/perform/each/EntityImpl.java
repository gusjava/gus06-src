package gus06.entity.gus.data.perform.each;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151123";}
	
	
	private Service performList;
	private Service performSet;
	private Service performMap;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.each");
		performSet = Outside.service(this,"gus.set.each");
		performMap = Outside.service(this,"gus.map.value.each");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
		{
			performList.p(obj);
			return;
		}
		
		if(input instanceof Set)
		{
			performSet.p(obj);
			return;
		}
		
		if(input instanceof Map)
		{
			performMap.p(obj);
			return;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
