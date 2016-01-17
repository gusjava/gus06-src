package gus06.entity.gus.java.dir.bin.javaexe;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140803";}

	
	private Service bin;
	private File javaExe;
	
	
	public EntityImpl() throws Exception
	{
		bin = Outside.service(this,"gus.java.dir.bin");
	}
	
	
	public Object g() throws Exception
	{
		if(javaExe==null) init();
		return javaExe;
	}
	
	
	private void init() throws Exception
	{
		File binDir = (File) bin.g();
		javaExe = new File(binDir,"java.exe");
		
		if(!javaExe.isFile())
			throw new Exception("Java exe file does not exist: "+javaExe);
	}
}
