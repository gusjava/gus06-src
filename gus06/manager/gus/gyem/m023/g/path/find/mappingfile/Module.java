package gus06.manager.gus.gyem.m023.g.path.find.mappingfile;

import java.io.File;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private File file;
	
	
	public Object g() throws Exception
	{
		if(file==null) file = init();
		return file;
	}
	
	
	private File init() throws Exception
	{
		File rootDir = (File) ((G) module(M021_G_PATH_FIND_ROOTDIR)).g();
		return file(rootDir,FILENAME_APPMAPPING);
	}
	
	
	private File file(File dir, String name)
	{
		if(dir!=null) return new File(dir,name);
		return new File(name);
	}
}