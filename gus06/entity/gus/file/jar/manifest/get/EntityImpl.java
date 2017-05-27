package gus06.entity.gus.file.jar.manifest.get;

import gus06.framework.*;
import java.io.File;
import java.util.jar.JarFile;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170223";}

	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(file==null) return null;
		
		JarFile jar = new JarFile(file,true,JarFile.OPEN_READ);
		return jar.getManifest();
	}
}
