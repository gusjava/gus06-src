package gus06.entity.gus.data.perform.mjoin;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160813";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		String glue1 = (String) o[1];
		String glue2 = (String) o[2];
		
		if(input instanceof Map)
		return join((Map) input,glue1,glue2);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	private String join(Map m, String glue1, String glue2)
	{
		StringBuffer b = new StringBuffer();
		List keys = new ArrayList(m.keySet());
		
		try{Collections.sort(keys);}
		catch(Exception e){}
		
		int n = keys.size();
		
		for(int i=0;i<n;i++)
		{
			Object key = keys.get(i);
			Object value = m.get(key);
			
			b.append(key+glue1+value);
			if(i<n-1) b.append(glue2);
		}
		return b.toString();
	}
}
