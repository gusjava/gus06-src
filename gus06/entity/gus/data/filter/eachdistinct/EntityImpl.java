package gus06.entity.gus.data.filter.eachdistinct;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160712";}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		Set set = new HashSet();
		for(Object o:oo)
		{
			if(o instanceof String)
			{
				String s = (String) o;
				if(!checkDistinct(set,s)) return false;
			}
			if(o instanceof Collection)
			{
				Collection c = (Collection) o;
				if(!checkDistinct(set,c)) return false;
			}
			else if(o instanceof Map)
			{
				Map m = (Map) o;
				if(!checkDistinct(set,m.keySet())) return false;
			}
			else if(o instanceof Object[])
			{
				Object[] t = (Object[]) o;
				if(!checkDistinct(set,Arrays.asList(t))) return false;
			}
		}
		return true;
	}
	
	
	private boolean checkDistinct(Set set, String s)
	{
		for(int i=0;i<s.length();i++)
		{
			String element = ""+s.charAt(i);
			if(set.contains(element)) return false;
			set.add(element);
		}
		return true;
	}
	
	
	private boolean checkDistinct(Set set, Collection c)
	{
		Iterator it = c.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			if(set.contains(element)) return false;
			set.add(element);
		}
		return true;
	}
}
