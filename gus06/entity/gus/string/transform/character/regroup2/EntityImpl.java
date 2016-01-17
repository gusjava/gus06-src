package gus06.entity.gus.string.transform.character.regroup2;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.equals("")) return "";
		
		StringBuffer b = new StringBuffer();
		
		char c1 = s.charAt(0);
		int n = 1;
		
		for(int i=1;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c!=c1)
			{
				b.append(n);
				b.append(c1);
				
				c1 = c;
				n = 1;
			}
			else n++;
		}
		
		b.append(n);
		b.append(c1);
		
		return b.toString();
	}
}
