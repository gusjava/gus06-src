package gus06.entity.gus.file.read.icon.from.gif;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160209";}


	private Service t;


	public EntityImpl() throws Exception
	{
		t = Outside.service(this,"gus.file.read.gif.asicon");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return t.t(obj);
	}
}
