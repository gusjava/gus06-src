package gus06.entity.gus.sys.script1.context.builder1.input;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151112";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		return obj;
	}
}