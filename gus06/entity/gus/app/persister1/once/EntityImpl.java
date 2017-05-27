package gus06.entity.gus.app.persister1.once;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20170320";}


	private Service persister1;


	public EntityImpl() throws Exception
	{
		persister1 = Outside.service(this,"gus.app.persister1");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		boolean found = persister1.f(""+obj);
		persister1.v(""+obj,"done");
		return !found;
	}
}
