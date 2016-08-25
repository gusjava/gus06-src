package gus06.entity.gus.data.perform.subcol.inv;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160519";}


	private Service subMap;
	private Service subList;
	private Service subSet;

	public EntityImpl() throws Exception
	{
		subMap = Outside.service(this,"gus.map.string.submap.inv");
		subList = Outside.service(this,"gus.list.string.sublist.inv");
		subSet = Outside.service(this,"gus.set.string.subset.inv");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Map) return subMap.t(obj);
		if(input instanceof List) return subList.t(obj);
		if(input instanceof Set) return subSet.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
