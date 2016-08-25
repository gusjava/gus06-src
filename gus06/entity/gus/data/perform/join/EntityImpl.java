package gus06.entity.gus.data.perform.join;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		String glue = (String) o[1];
		
		if(input instanceof String[])
		return join((String[]) input,glue);
		
		if(input instanceof List)
		return join((List) input,glue);
		
		if(input instanceof Set)
		return join((Set) input,glue);
		
		if(input instanceof Map)
		return join((Map) input,glue);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	private String join(String[] s, String glue)
	{
		StringBuffer b = new StringBuffer();
		int n = s.length;
		
		for(int i=0;i<n;i++)
		{
			b.append(s[i]);
			if(i<n-1) b.append(glue);
		}
		return b.toString();
	}
	
	
	private String join(List l, String glue)
	{
		StringBuffer b = new StringBuffer();
		int n = l.size();
		
		for(int i=0;i<n;i++)
		{
			b.append(l.get(i));
			if(i<n-1) b.append(glue);
		}
		return b.toString();
	}
	
	
	private String join(Set s, String glue)
	{
		List l = new ArrayList(s);
		Collections.sort(l);
		return join(l,glue);
	}
	
	
	private String join(Map m, String glue)
	{
		StringBuffer b = new StringBuffer();
		List keys = new ArrayList(m.keySet());
		Collections.sort(keys);
		int n = keys.size();
		
		for(int i=0;i<n;i++)
		{
			Object key = keys.get(i);
			Object value = m.get(key);
			
			b.append(key+"="+value);
			if(i<n-1) b.append(glue);
		}
		return b.toString();
	}
}
