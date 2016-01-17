package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.roots;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151003";}


	private Service manager;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
	}
	
	
	public void e() throws Exception
	{
		File[] roots = File.listRoots();
		for(File root:roots) if(root.exists())
		manager.v("add",root);
	}
}
