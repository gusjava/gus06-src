package gus06.entity.gus.appli.convertisseurgus05.execute.selected.openfiles;

import gus06.framework.*;
import java.io.File;
import java.io.FileFilter;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150525";}
	
	public static final FileFilter FILTER = new FileFilter() {
		public boolean accept(File f)
		{return f.isFile() && f.getName().endsWith(".java");}
	};


	private Service getSelected;
	private Service nameToDir;
	private Service open;


	public EntityImpl() throws Exception
	{
		getSelected = Outside.service(this,"gus.appli.convertisseurgus05.holder.selected");
		nameToDir = Outside.service(this,"gus.appli.convertisseurgus05.data.gus05.nametodir");
		open = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) getSelected.g();
		if(name==null) return;
		File dir = (File) nameToDir.t(name);
		if(dir==null || !dir.isDirectory()) return;
		
		File[] files = dir.listFiles(FILTER);
		for(File file:files) open.p(file);
	}
}
