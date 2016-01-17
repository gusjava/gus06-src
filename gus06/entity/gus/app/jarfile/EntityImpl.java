package gus06.entity.gus.app.jarfile;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140703";}

	
	private File appJarFile;
	
	
	public Object g() throws Exception
	{
		if(appJarFile==null)
    		appJarFile = findAppFile();
		return appJarFile;
	}
	
	private File findAppFile() throws Exception
	{return new File(Outside.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());}
}
