package gus06.entity.gus.java.home.rtjar;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140728";}

	private Service findHome;
	private File file;
	
	public EntityImpl() throws Exception
	{
		findHome = Outside.service(this,"gus.java.dir.home");
	}
	
	
	public Object g() throws Exception
	{
		if(file==null) init();
		return file;
	}
	
	
	private void init() throws Exception
	{
		File dir = (File) findHome.g();
		File lib = new File(dir,"lib");
		
		file = new File(lib,"rt.jar");
		if(!file.exists()) throw new Exception("File not found: "+file);
	}
}
