package gus06.entity.gus.data.perform.collect;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}
	
	
	private Service performList;
	private Service performSet;
	private Service performMap;
	private Service performArray;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.collect");
		performSet = Outside.service(this,"gus.set.collect");
		performMap = Outside.service(this,"gus.map.value.collect");
		performArray = Outside.service(this,"gus.array.collect");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List) return performList.t(obj);
		if(input instanceof Set) return performSet.t(obj);
		if(input instanceof Map) return performMap.t(obj);
		if(input instanceof Object[]) return performArray.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
