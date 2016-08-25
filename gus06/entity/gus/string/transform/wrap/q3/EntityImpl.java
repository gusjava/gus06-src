package gus06.entity.gus.string.transform.wrap.q3;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160502";}


	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return "("+obj+")";
	}
}
