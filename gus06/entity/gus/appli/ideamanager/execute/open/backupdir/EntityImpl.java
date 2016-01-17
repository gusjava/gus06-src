package gus06.entity.gus.appli.ideamanager.execute.open.backupdir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151013";}


	private Service getDir;
	private Service openDir;


	public EntityImpl() throws Exception
	{
		getDir = Outside.service(this,"gus.data.backuper.string");
		openDir = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public void e() throws Exception
	{
		File dir = (File) getDir.g();
		openDir.p(dir);
	}
}
