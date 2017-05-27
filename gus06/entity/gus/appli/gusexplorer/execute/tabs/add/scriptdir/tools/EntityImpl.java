package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.scriptdir.tools;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20160909";}


	private Service manager;
	private Service dirHolder;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		dirHolder = Outside.service(this,"gus.appli.gusexplorer.scripts.tools.manager");
	}
	
	
	public void e() throws Exception
	{
		File dir = (File) dirHolder.r("dir");
		manager.v("add",dir);
	}
}
