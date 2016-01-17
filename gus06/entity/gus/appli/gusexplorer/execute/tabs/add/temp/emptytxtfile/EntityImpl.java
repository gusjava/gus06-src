package gus06.entity.gus.appli.gusexplorer.execute.tabs.add.temp.emptytxtfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151008";}
	
	public static final String EXTENSION = "txt";


	private Service manager;
	private Service buildFile;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		buildFile = Outside.service(this,"gus.sys.clipboard1.g.listfiles.buildfile");
	}
	
	
	public void e() throws Exception
	{
		File file = (File) buildFile.t(EXTENSION);
		file.createNewFile();
		manager.v("add",file);
	}
}
