package gus06.entity.gus.data.perform.filter.count;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}
	
	
	private Service performList;
	private Service performSet;
	private Service performMap;
	
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.filter.count");
		performSet = Outside.service(this,"gus.set.filter.count");
		performMap = Outside.service(this,"gus.map.entry.filter.count");
	}	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Set) return performSet.t(obj);
		if(input instanceof Map) return performMap.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
