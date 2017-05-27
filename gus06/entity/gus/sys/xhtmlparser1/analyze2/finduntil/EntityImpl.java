package gus06.entity.gus.sys.xhtmlparser1.analyze2.finduntil;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170131";}

	
	
	
	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		return "/"+name;
	}
}