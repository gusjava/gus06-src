package gus06.entity.gus.java.jdk.dirs;

import java.io.File;
import java.io.FileFilter;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140722";}

	
	private Service javaRoot;
	private File[] dirs;

	public EntityImpl() throws Exception
	{
		javaRoot = Outside.service(this,"gus.java.dir.root");
	}
	
	
	public Object g() throws Exception
	{
		if(dirs==null) init();
		return dirs;
	}
	
	
	private void init() throws Exception
	{
		File root = (File) javaRoot.g();
		dirs = root.listFiles(new JdkDirFilter());
	}
	
	
	
	
	private class JdkDirFilter implements FileFilter
	{
		public boolean accept(File f)
		{
			if(!f.isDirectory()) return false;
			
			String name = f.getName().toLowerCase();
			if(!name.startsWith("jdk")) return false;
			
			File binDir = new File(f,"bin");
			if(!binDir.isDirectory()) return false;
			
			return true;
		}
	}
}
