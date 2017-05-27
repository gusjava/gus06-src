package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.approotdir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20160917";}


	private Service manager;
	private File rootDir;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		rootDir = (File) Outside.resource(this,"rootdir");
	}
	
	
	public void e() throws Exception
	{
		manager.v("add",rootDir);
	}
}
