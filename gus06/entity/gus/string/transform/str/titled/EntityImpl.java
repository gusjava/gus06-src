package gus06.entity.gus.string.transform.str.titled;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140915";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.equals("")) return "";
		
		StringBuffer b = new StringBuffer();
		boolean space = true;
		
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(space) c = Character.toUpperCase(c);
			space = c==' ' || c=='\t' || c=='\n';
			b.append(c);
		}
		return b.toString();
	}
}
