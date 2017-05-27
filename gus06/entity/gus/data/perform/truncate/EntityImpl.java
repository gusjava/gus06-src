package gus06.entity.gus.data.perform.truncate;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160129";}


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
		int limit = findIndex(o);
		if(limit<0) throw new Exception("Invalid limit value: "+limit);
		
		if(input instanceof String)
		{
			return ((String) input).substring(0,limit);
		}
		
		if(input instanceof List)
		{
			List output = new ArrayList((List) input);
			truncate(output,limit);
			return output;
		}
		
		if(input instanceof Set)
		{
			Set output = new HashSet((Set) input);
			truncate(output,limit);
			return output;
		}
		
		if(input instanceof Map)
		{
			Map output = new HashMap((Map) input);
			truncate(output,limit);
			return output;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		int limit = toInt(o[1]);
		if(limit<0) throw new Exception("Invalid limit value: "+limit);
		
		if(input instanceof List)
		{
			truncate((List) input,limit);
			return;
		}
		
		if(input instanceof Set)
		{
			truncate((Set) input,limit);
			return;
		}
		
		if(input instanceof Map)
		{
			truncate((Map) input,limit);
			return;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(obj.toString());}
	
	
	
	private void truncate(List list, int limit)
	{
		while(list.size()>limit)
		{
			list.remove(list.size()-1);
		}
	}
	
	private void truncate(Set set, int limit)
	{
		Iterator it = set.iterator();
		while(set.size()>limit)
		{
			it.next();
			it.remove();
		}
	}
	
	private void truncate(Map map, int limit)
	{
		Iterator it = map.keySet().iterator();
		while(map.size()>limit)
		{
			it.next();
			it.remove();
		}
	}
	
	
	
	private int findIndex(Object obj) throws Exception
	{
		Integer n = (Integer) ruleToIndex.t(obj);
		return n==null? -1 : n.intValue();
	}
}
