package gus06.entity.gus.appli.gusexplorer.execute.tabs.close.all;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151003";}


	private Service manager;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
	}
	
	
	public void e() throws Exception
	{
		manager.v("clear",null);
	}
}
