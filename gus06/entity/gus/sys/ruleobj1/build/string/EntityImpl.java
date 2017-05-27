package gus06.entity.gus.sys.ruleobj1.build.string;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170117";}

	
	public Object t(Object obj) throws Exception
	{
		return (String) obj;
	}
}
