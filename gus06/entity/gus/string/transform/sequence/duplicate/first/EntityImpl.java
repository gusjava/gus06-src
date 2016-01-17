package gus06.entity.gus.string.transform.sequence.duplicate.first;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	public static final String DELIM = ";";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		int length = n.length;
		
		StringBuffer b = new StringBuffer();
		
		if(length>0) b.append(n[0]+DELIM);
		
		for(int i=0;i<length;i++)
		{
			b.append(n[i]+DELIM);
			b.append(n[i]+DELIM);
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
