package gus06.entity.gus.string.transform.integer.checkneg;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		try
		{
			int n = Integer.parseInt((String) obj);
			boolean check = n<0;
			return ""+check;
		}
		catch(NumberFormatException e) {}
		return obj;
	}
}