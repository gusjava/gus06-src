package gus06.entity.gus.appli.gusclient1.project.release.gui.snapshots.findframe;

import gus06.framework.*;
import java.io.File;
import java.awt.Rectangle;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141015";}


	private Service readFile;

	
	private File homeDir;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		homeDir = (File) Outside.resource(this,"path#path.sys.user.home");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String id = (String) obj;
		
		File d = new File(homeDir,".gus06");
		d = new File(d,"app_"+id);
		d = new File(d,"pool");
		d = new File(d,"gus.app.persister1");
		
		File f = new File(d,"mainframe.bounds.txt");
		if(!f.exists()) return null;
		
		String s = (String) readFile.t(f);
		if(s.equals("")) return null;
		
		String[] n = s.split(" ");
		if(n.length!=4) return null;
		
		int x = int_(n[0]);
		int y = int_(n[1]);
		int w = int_(n[2]);
		int h = int_(n[3]);
		
		return new Rectangle(x,y,w,h);
	}
	
	private int int_(String s)
	{return Integer.parseInt(s);}
}
