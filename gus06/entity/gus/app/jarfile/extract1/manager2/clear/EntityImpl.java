package gus06.entity.gus.app.jarfile.extract1.manager2.clear;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140908";}


	private Service emptyDir;
	private File dir;
	
	public EntityImpl() throws Exception
	{
		emptyDir = Outside.service(this,"gus.dir.perform.empty");
		dir = (File) Outside.resource(this,"path#path.dev.managerdir2");
	}
	
	
	public void e() throws Exception
	{
		if(!dir.exists()) dir.mkdirs();
		emptyDir.p(dir);
	}
}
