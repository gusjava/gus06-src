package gus06.entity.gus.java.home.ext.dirs;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140820";}

	private File[] dirs;
	
	public EntityImpl() throws Exception
	{}
	
	
	public Object g() throws Exception
	{
		if(dirs==null) init();
		return dirs;
	}
	
	
	private void init() throws Exception
	{
		String ext = System.getProperty("java.ext.dirs");
		String[] n = ext.split(File.pathSeparator);
		
		dirs = new File[n.length];
		for(int i=0;i<n.length;i++) dirs[i] = new File(n[i]); 
	}
}
