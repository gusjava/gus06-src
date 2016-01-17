package gus06.entity.gus.java.dir.user;

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
		String path = System.getProperty("user.dir");
		dir = new File(path);
		
		if(!dir.isDirectory()) throw new Exception("Java user directory does not exist: "+dir);
	}
}
