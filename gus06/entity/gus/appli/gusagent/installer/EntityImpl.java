package gus06.entity.gus.appli.gusagent.installer;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity {

	public String creationDate() {return "20150626";}
	
	public static final String PATH = "path.appli";


	private Service fileProvider;
	private Service restart1;
	private Service startupLnk;
	private Service clearLauncher;
	


	public EntityImpl() throws Exception
	{
		fileProvider = Outside.service(this,"fileprovider");
		restart1 = Outside.service(this,"gus.app.restart1");
		clearLauncher = Outside.service(this,"gus.app.restart1.clearlauncher");
		startupLnk = Outside.service(this,"gus.file.lnk.create.shortcut2.appjar.onstartup");
		
		restart1.p(appFile());
		clearLauncher.e();
		startupLnk.e();
	}
	
	
	private File appFile() throws Exception
	{return (File) fileProvider.r(PATH);}
}
