package gus06.entity.gus.string.transform.tab.duplicate.all;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	public static final String DELIM = "\t";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split("\n",-1);
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<n.length;i++)
		{
			String[] parts = n[i].split(DELIM,-1);
			int length = parts.length;
			
			for(int j=0;j<length;j++)
			{
				b.append(parts[j]+DELIM+parts[j]);
				if(j<length-1) b.append(DELIM);
			}
			
			b.append("\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
