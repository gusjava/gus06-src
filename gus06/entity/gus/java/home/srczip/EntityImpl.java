package gus06.entity.gus.java.home.srczip;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140819";}

	private Service findJdk;
	private File file;
	
	public EntityImpl() throws Exception
	{
		findJdk = Outside.service(this,"gus.java.jdk.currentdir");
	}
	
	
	public Object g() throws Exception
	{
		if(file==null) init();
		return file;
	}
	
	
	private void init() throws Exception
	{
		File dir = (File) findJdk.g();
		if(dir==null) return;
		
		file = new File(dir,"src.zip");
		if(!file.exists()) throw new Exception("File not found: "+file);
	}
}
