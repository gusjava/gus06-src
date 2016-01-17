package gus06.entity.gus.file.lnk.create.shortcut2.appjar.onstartup;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150607";}


	private Service createAppJarShortcut;
	private Service findStartupFolder;
	

	public EntityImpl() throws Exception
	{
		createAppJarShortcut = Outside.service(this,"gus.file.lnk.create.shortcut2.appjar");
		findStartupFolder = Outside.service(this,"gus.env.windows.folder.startup");
	}

	public void e() throws Exception
	{
		File dir = (File) findStartupFolder.g();
		createAppJarShortcut.p(dir);
	}
}