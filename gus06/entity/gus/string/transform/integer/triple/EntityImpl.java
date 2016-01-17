package gus06.entity.gus.string.transform.integer.triple;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		try
		{
			int n = Integer.parseInt((String) obj);
			return ""+(n*3);
		}
		catch(NumberFormatException e) {}
		return obj;
	}
}