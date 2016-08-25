package gus06.entity.gus.string.transform.line.remove.empty;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<n.length;i++)
		if(!valid(n[i])) b.append(n[i]+DELIM);
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	private boolean valid(String n)
	{return n.equals("");}
}
