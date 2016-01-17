package gus06.entity.gus.file.read.image.from.video;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}


	private Service default0;


	public EntityImpl() throws Exception
	{
		default0 = Outside.service(this,"gus.file.read.image.generic.default0");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return default0.t(obj);
	}
}
