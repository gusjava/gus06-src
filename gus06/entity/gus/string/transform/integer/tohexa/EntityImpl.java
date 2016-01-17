package gus06.entity.gus.string.transform.integer.tohexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}
	
	
	public Object t(Object obj) throws Exception
	{
		try
		{
			int n = Integer.parseInt((String) obj);
			return Integer.toHexString(n).toUpperCase();
		}
		catch(NumberFormatException e) {}
		return obj;
	}
}