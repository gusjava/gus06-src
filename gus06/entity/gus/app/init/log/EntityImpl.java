package gus06.entity.gus.app.init.log;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;

public class EntityImpl implements Entity {

	public String creationDate() {return "20141023";}


	private Service findFile;
	private Service sysoutManager;



	public EntityImpl() throws Exception
	{
		findFile = Outside.service(this,"gus.app.init.log.findfile");
		sysoutManager = Outside.service(this,"gus.system.out.manager");
		
		File file = (File) findFile.g();
		PrintStream p = new PrintStream(file);
		
		sysoutManager.p(p);
	}
}
