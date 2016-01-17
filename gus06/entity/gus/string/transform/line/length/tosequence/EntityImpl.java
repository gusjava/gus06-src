package gus06.entity.gus.string.transform.line.length.tosequence;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150929";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		StringBuffer b = new StringBuffer();
		for(String n:nn)
		{
			int length = n.trim().length();
			b.append(length+";");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
