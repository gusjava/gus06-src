package gus06.entity.gus.sys.store2.build.mapaccess2.dir.properties;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160313";}

	private Service dirAccessBuilder;
	private Service mapAccess;

	public EntityImpl() throws Exception
	{
		dirAccessBuilder = Outside.service(this,"gus.dir.accessbuilder2.properties");
		mapAccess = Outside.service(this,"gus.sys.store2.build.mapaccess2");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object dirAccess = dirAccessBuilder.t(obj);
		return mapAccess.t(dirAccess);
	}
}
