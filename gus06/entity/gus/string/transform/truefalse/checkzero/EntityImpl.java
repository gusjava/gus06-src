package gus06.entity.gus.string.transform.truefalse.checkzero;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.equals("0")) return "false";
		return "true";
	}
}
