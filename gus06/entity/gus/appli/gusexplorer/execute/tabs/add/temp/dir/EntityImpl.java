package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.temp.dir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151008";}


	private Service manager;
	private Service tempDirHolder;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		tempDirHolder = Outside.service(this,"gus.sys.clipboard1.g.listfiles.buildfile");
	}
	
	
	public void e() throws Exception
	{
		File dir = (File) tempDirHolder.g();
		manager.v("add",dir);
	}
}
