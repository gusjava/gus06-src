package gus06.entity.gus.convert.stringtoentity;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150626";}


	private Service entityUnique;

	public EntityImpl() throws Exception
	{
		entityUnique = Outside.service(this,"entityunique");
	}
	
	public Object t(Object obj) throws Exception
	{
		return entityUnique.t(obj);
	}
}