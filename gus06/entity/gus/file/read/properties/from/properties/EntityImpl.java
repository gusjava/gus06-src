package gus06.entity.gus.file.read.properties.from.properties;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151018";}


	private Service propFromProp;


	public EntityImpl() throws Exception
	{
		propFromProp = Outside.service(this,"gus.file.read.properties");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return propFromProp.t(obj);
	}
}
