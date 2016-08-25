package gus06.entity.gus.sys.store2.build.mapaccess.dir.properties;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160309";}

	private Service dirAccessBuilder;
	private Service mapAccess;

	public EntityImpl() throws Exception
	{
		dirAccessBuilder = Outside.service(this,"gus.dir.accessbuilder.properties");
		mapAccess = Outside.service(this,"gus.sys.store2.build.mapaccess");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object dirAccess = dirAccessBuilder.t(obj);
		return mapAccess.t(dirAccess);
	}
}
