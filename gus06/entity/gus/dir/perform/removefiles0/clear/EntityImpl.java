package gus06.entity.gus.dir.perform.removefiles0.clear;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140906";}


	private Service remove;
	private Service clear;
	
	
	
	public EntityImpl() throws Exception
	{
		remove = Outside.service(this,"gus.dir.perform.removefiles0");
		clear = Outside.service(this,"gus.dir.perform.clear");
	}

	
	public void p(Object obj) throws Exception
	{
		remove.p(obj);
		clear.p(obj);
	}
}