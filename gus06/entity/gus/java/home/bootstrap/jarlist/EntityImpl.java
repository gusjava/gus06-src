package gus06.entity.gus.java.home.bootstrap.jarlist;

import gus06.framework.*;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;


public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140822";}

	private ArrayList files;
	
	
	public Object g() throws Exception
	{
		if(files==null) init();
		return files;
	}
	
	
	private void init() throws Exception
	{
		files = new ArrayList();
		
		String bootstrap = System.getProperty("sun.boot.class.path");
		String[] n = bootstrap.split(File.pathSeparator);
		
		for(String path:n)
		{
			File jar = new File(path);
			if(isJar(jar)) files.add(jar);
		}
	}
	
	
	private boolean isJar(File jar)
	{return jar.isFile() && jar.getName().endsWith(".jar");}
}
