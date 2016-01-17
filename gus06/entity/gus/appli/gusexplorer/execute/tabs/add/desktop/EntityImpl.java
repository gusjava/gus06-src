package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.desktop;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151010";}


	private Service manager;
	private Service findDesktop;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		findDesktop = Outside.service(this,"gus.env.windows.folder.desktop");
	}
	
	
	public void e() throws Exception
	{
		File dir = (File) findDesktop.g();
		manager.v("add",dir);
	}
}
