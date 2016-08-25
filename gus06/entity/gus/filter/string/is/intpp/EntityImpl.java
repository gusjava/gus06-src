package gus06.entity.gus.filter.string.is.intpp;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160816";}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		
		try
		{
			int n = Integer.parseInt(s);
			return n>0;
		}
		catch(NumberFormatException e)
		{return false;}
	}
}