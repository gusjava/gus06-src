package gus06.manager.gus.gyem.m042.p.entity.jarfile.updatecache;

import java.io.File;

import gus06.framework.P;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;

public class Module extends GyemSystem implements P {

	
	public void p(Object obj) throws Exception
	{
		File file1 = (File) obj;
		String name = file1.getName();
		
		File jarDir = (File) ((R) module(M102_R_FILEPROVIDER)).r(PATH_GYEM_JARDIR);
		File file0 = new File(jarDir,name);
		
		if(file0.isDirectory())
			throw new Exception("Path is not expected to be a directory: "+file0);
		
		if(!file0.exists())
		((P) module(M109_P_IMPORTENTITY)).p(file0);
		
		if(file0.exists())
		Tool_File.copy(file0,file1);
	}
}