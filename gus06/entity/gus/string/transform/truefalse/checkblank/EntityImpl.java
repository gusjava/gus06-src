package gus06.entity.gus.string.transform.truefalse.checkblank;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160620";}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.trim().equals("")) return "false";
		return "true";
	}
}
