package gus06.entity.gus.string.transform.character.keep.uppercase;

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
			if(Character.isUpperCase(c)) b.append(c);
		}
		return b.toString();
	}
}
