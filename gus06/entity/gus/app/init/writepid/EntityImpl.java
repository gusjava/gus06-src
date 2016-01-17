package gus06.entity.gus.app.init.writepid;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;


public class EntityImpl implements Entity {

	public String creationDate() {return "20140807";}


	private Service getPid;
	private File rootDir;
	

	public EntityImpl() throws Exception
	{
		getPid = Outside.service(this,"gus.app.pid");
		rootDir = (File) Outside.resource(this,"rootdir");
		if(!rootDir.exists()) rootDir.mkdirs();
		
		String pid = (String) getPid.g();
		File file = new File(rootDir,"pid");
		
		PrintStream p = new PrintStream(file);
		p.print(pid);
		p.close();
	}
}
