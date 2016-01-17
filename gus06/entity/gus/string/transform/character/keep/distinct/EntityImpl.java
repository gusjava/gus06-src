package gus06.entity.gus.string.transform.character.keep.distinct;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(notFound(b,c)) b.append(c);
		}
		return b.toString();
	}
	
	
	private boolean notFound(StringBuffer b, char c)
	{return b.indexOf(""+c)<0;}
}
