package gus06.entity.gus.string.transform.integer.square;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		try
		{
			int n = Integer.parseInt((String) obj);
			return ""+(n*n);
		}
		catch(NumberFormatException e) {}
		return obj;
	}
}