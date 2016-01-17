package gus06.entity.gus.java.dir.bin;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140705";}

	
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
		dir = new File(homeDir,"bin");
		
		if(!dir.isDirectory())
			throw new Exception("Java bin directory does not exist: "+dir);
	}
}
