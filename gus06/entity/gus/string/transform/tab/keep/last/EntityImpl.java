package gus06.entity.gus.string.transform.tab.keep.last;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}
	
	public static final String DELIM = "\t";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split("\n",-1);
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<n.length;i++)
		{
			String[] parts = n[i].split(DELIM,-1);
			b.append(parts[parts.length-1]+"\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
