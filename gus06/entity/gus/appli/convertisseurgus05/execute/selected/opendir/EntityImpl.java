package gus06.entity.gus.appli.convertisseurgus05.execute.selected.opendir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150525";}


	private Service getSelected;
	private Service nameToDir;
	private Service openDir;


	public EntityImpl() throws Exception
	{
		getSelected = Outside.service(this,"gus.appli.convertisseurgus05.holder.selected");
		nameToDir = Outside.service(this,"gus.appli.convertisseurgus05.data.gus05.nametodir");
		openDir = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) getSelected.g();
		if(name==null) return;
		File dir = (File) nameToDir.t(name);
		if(dir==null || !dir.isDirectory()) return;
		openDir.p(dir);
	}
}
