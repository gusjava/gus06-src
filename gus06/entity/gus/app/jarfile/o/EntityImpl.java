package gus06.entity.gus.app.jarfile.o;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140802";}

	
	private Service appJarFile;
	
	public EntityImpl() throws Exception
	{
		appJarFile = Outside.service(this,"gus.app.jarfile");
	}
	
	
	public Object g() throws Exception
	{
		File file = (File) appJarFile.g();
		return new File(file.getParentFile(),newName(file));
	}
	
	
	private String newName(File file)
	{
		String n = file.getName();
		if(n.endsWith(".jar")) n = n.substring(0,n.length()-4);
		return n+"_1.jar";
	}
}
