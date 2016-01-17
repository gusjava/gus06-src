package gus06.entity.gus.appli.gusclient1.execute.space.projects.openrootdir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150312";}


	private Service findRootDir;
	private Service showWarning;
	private Service openDir;


	public EntityImpl() throws Exception
	{
		findRootDir = Outside.service(this,"gus.appli.gusclient1.project.config.load2.path.findrootdir");
		showWarning = Outside.service(this,"gus.swing.optionpane.showmessage.warning");
		openDir = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public void e() throws Exception
	{
		File rootDir = (File) findRootDir.g();
		
		if(rootDir==null)
		{warning("Root dir not defined");return;}
		
		if(!rootDir.isDirectory())
		{warning("Root dir not found: "+rootDir);return;}
		
		openDir.p(rootDir);
	}
	
	
	private void warning(String message) throws Exception
	{showWarning.p(message);}
}
