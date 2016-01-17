package gus06.entity.gus.appli.gusclient1.execute.entity.opendir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20141014";}


	private Service selection;
	private Service findDir;
	private Service openDir;
	

	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
		findDir = Outside.service(this,"gus.entitydev.entityname.packagedir");
		openDir = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) selection.g();
		if(name==null) return;
		
		File dir = (File) findDir.t(name);
		openDir.p(dir);
	}
}
