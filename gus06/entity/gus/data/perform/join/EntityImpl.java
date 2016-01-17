package gus06.entity.gus.data.perform.join;

import gus06.framework.*;
import java.util.List;

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
}
