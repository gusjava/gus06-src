package gus06.entity.gus.data.perform.splitlen;

import gus06.framework.*;
import java.util.List;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151130";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		int len = toInt(o[1]);
		
		if(input instanceof String)
		return split((String) input,len);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt((String) obj);}
	
	
	
	private String[] split(String s, int len)
	{
		int length = s.length();
		int nb = length/len;
		if(length%len>0) nb++;
		
		String[] n = new String[nb];
		for(int i=0;i<nb;i++)
		{
			int start = i*len;
			int end = start+len;
			n[i] = s.substring(start,Math.min(end,length));
		}
		return n;
	}
}
