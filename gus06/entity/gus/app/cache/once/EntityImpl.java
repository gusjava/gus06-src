package gus06.entity.gus.app.cache.once;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20170320";}


	private Service cache;


	public EntityImpl() throws Exception
	{
		cache = Outside.service(this,"gus.app.cache");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		boolean found = cache.f(""+obj);
		cache.v(""+obj,"done");
		return !found;
	}
}
