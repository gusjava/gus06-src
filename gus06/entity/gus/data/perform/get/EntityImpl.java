package gus06.entity.gus.data.perform.get;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170419";}


	private Service ruleToIndex;
	
	public EntityImpl() throws Exception
	{
		ruleToIndex = Outside.service(this,"gus.list.ruletoindex");
		
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		Object key = o[1];
		
		if(input instanceof List)
			return get((List) input, key);
		
		if(input instanceof Map)
			return get((Map) input, key);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	private Object get(List list, Object key) throws Exception
	{
		Integer index = (Integer) ruleToIndex.t(new Object[]{list,key});
		if(index==null) return null;
		return list.get(index.intValue());
	}
	
	private Object get(Map map, Object key) throws Exception
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
}
