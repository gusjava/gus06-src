package gus06.entity.gus.string.transform.character.case0.randomcase;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
		    char c = s.charAt(i);
		    if(Math.random()<0.5)
				b.append(Character.toLowerCase(c));
		    else b.append(Character.toUpperCase(c));
		}
		return b.toString();
	}
}
