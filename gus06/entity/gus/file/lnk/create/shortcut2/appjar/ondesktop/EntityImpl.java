package gus06.entity.gus.file.lnk.create.shortcut2.appjar.ondesktop;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150607";}


	private Service createAppJarShortcut;
	private Service findDesktopFolder;
	

	public EntityImpl() throws Exception
	{
		createAppJarShortcut = Outside.service(this,"gus.file.lnk.create.shortcut2.appjar");
		findDesktopFolder = Outside.service(this,"gus.env.windows.folder.desktop");
	}

	public void e() throws Exception
	{
		File dir = (File) findDesktopFolder.g();
		createAppJarShortcut.p(dir);
	}
}