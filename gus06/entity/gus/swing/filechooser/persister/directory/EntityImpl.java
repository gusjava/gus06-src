package gus06.entity.gus.swing.filechooser.persister.directory;

import gus06.framework.*;
import javax.swing.JFileChooser;
import java.io.File;


public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150522";}


	private Service manager;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.app.persister1.manager");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		final JFileChooser comp = (JFileChooser) obj;
		
		String text = (String) manager.r(key);
		File dir = toDir(text);
		if(dir!=null && dir.isDirectory())
		comp.setCurrentDirectory(dir);
		
		manager.v(key,new G(){
			public Object g() throws Exception {return ""+toDir(comp);}
		});
	}
	
	
	
	private File toDir(String s)
	{
		if(s==null || s.equals("")) return null;
		File dir = new File(s);
		while(dir!=null && !dir.isDirectory())
			dir = dir.getParentFile();
		return dir;
	}
	
	private File toDir(JFileChooser comp)
	{return comp.getCurrentDirectory();}
}
