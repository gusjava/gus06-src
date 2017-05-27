package gus06.entity.gus.string.transform.str.trim.start;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}
	
	public static final String WHITE = " \t\n\r";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		if(s==null) return null;
		if(s.equals("")) return "";
		
		int offset = findOffset(s);
		return s.substring(offset);
	}
	
	private int findOffset(String s)
	{
		int i = 0;
		while(WHITE.indexOf(s.charAt(i))>=0) i++;
		return i;
	}
}