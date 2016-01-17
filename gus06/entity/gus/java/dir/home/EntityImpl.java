package gus06.entity.gus.java.dir.home;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140722";}


	private File dir;
	
	
	public Object g() throws Exception
	{
		if(dir==null) init();
		return dir;
	}
	
	
	private void init() throws Exception
	{
		String path = System.getProperty("java.home");
		dir = new File(path);
		
		if(!dir.isDirectory()) throw new Exception("Java home directory does not exist: "+dir);
	}
}
