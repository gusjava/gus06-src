package gus06.entity.gus.java.jdk.latestdir;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140722";}

	
	private Service jdkDirs;
	private JdkComparator comparator = new JdkComparator();
	
	
	private File dir;

	public EntityImpl() throws Exception
	{
		jdkDirs = Outside.service(this,"gus.java.jdk.dirs");
	}
	
	
	public Object g() throws Exception
	{
		if(dir==null) init();
		return dir;
	}
	
	
	private void init() throws Exception
	{
		File[] dirs = (File[]) jdkDirs.g();
		if(dirs==null || dirs.length==0) return;
    	
		dir = dirs[0];
		for(int i=1;i<dirs.length;i++)
		if(comparator.compare(dirs[i],dir)==1) dir = dirs[i];
	}
}
