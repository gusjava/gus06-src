package gus06.entity.gus.convert.stringtostring;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150626";}

	
	public Object t(Object obj) throws Exception
	{
		return (String) obj;
	}
}
