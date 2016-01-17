package gus06.entity.gus.java.dir.root;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140722";}


	private Service home;
	private File dir;
	
	
	public EntityImpl() throws Exception
	{
		home = Outside.service(this,"gus.java.dir.home");
	}
	
	
	public Object g() throws Exception
	{
		if(dir==null) init();
		return dir;
	}
	
	
	
	
	private void init() throws Exception
	{
		File homeDir = (File) home.g();
		
		dir = homeDir.getParentFile();
    		while(dir!=null && !isJavaRoot(dir))
    		dir = dir.getParentFile();
		if(dir==null) throw new Exception("Java root directory does not exist: "+dir);
	}
	
	
	private boolean isJavaRoot(File dir)
	{return dir.getName().toLowerCase().equals("java");}
}
