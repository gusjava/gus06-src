package gus06.entity.gus.filter.string.is.number;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160729";}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		try{Double.parseDouble(s);return true;}
		catch(NumberFormatException e){return false;}
	}
}