package gus06.entity.gus.string.transform.integer.clearzero;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}
	
	
	public Object t(Object obj) throws Exception
	{
		try
		{
			int n = Integer.parseInt((String) obj);
			if(n==0) return "";
		}
		catch(NumberFormatException e) {}
		return obj;
	}
}