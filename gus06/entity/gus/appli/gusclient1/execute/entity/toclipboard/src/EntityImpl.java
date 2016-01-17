package gus06.entity.gus.appli.gusclient1.execute.entity.toclipboard.src;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150225";}
	

	private Service selection;
	private Service findDir;
	private Service dirToSrc;
	private Service toClipboard;

	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
		findDir = Outside.service(this,"gus.entitydev.entityname.packagedir");
		dirToSrc = Outside.service(this,"gus.entitydev.dirtosrc.full");
		toClipboard = Outside.service(this,"gus.clipboard.access.string");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) selection.g();
		if(name==null) return;
		
		File dir = (File) findDir.t(name);
		String src = (String) dirToSrc.t(dir);
		
		toClipboard.p(src);
	}
}
