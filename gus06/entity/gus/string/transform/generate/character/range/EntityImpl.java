package gus06.entity.gus.string.transform.generate.character.range;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160512";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		StringBuffer b = new StringBuffer();
		
		String[] n = s.split(" ");
		int start = int_(n[0]);
		int end = int_(n[1]);
		
		if(start<=end)
		{
			for(int i=start;i<=end;i++)
			b.append(Character.toChars(i));
		}
		else
		{
			for(int i=start;i>=end;i--)
			b.append(Character.toChars(i));
		}
		
		return b.toString();
	}
	
	
	private int int_(String s)
	{return Integer.parseInt(s);}
}