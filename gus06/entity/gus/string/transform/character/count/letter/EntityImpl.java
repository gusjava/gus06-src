package gus06.entity.gus.string.transform.character.count.letter;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		int count = 0;
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(Character.isLetter(c)) count++;
		}
		return ""+count;
	}
}
