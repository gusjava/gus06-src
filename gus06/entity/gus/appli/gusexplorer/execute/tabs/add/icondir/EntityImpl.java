package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.icondir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20160914";}


	private Service manager;
	private Service dirHolder;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		dirHolder = Outside.service(this,"gus.icon.loader.outside");
	}
	
	
	public void e() throws Exception
	{
		File dir = (File) dirHolder.g();
		manager.v("add",dir);
	}
}
