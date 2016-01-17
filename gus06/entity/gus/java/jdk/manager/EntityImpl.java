package gus06.entity.gus.java.jdk.manager;

import java.io.File;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, G, P {

	public String creationDate() {return "20140722";}

	private Service jdkDirs;
	private Service jdkLatest;
	
	private File dir;
	

	public EntityImpl() throws Exception
	{
		jdkDirs = Outside.service(this,"gus.java.jdk.dirs");
		jdkLatest = Outside.service(this,"gus.java.jdk.latestdir");
	}
	
	
	public Object g() throws Exception
	{
		if(dir==null) init();
		return dir;
	}
	
	
	public void p(Object obj) throws Exception
	{
		dir = (File) obj;
	}
	
	
	
	private void init() throws Exception
	{
		dir = (File) jdkLatest.g();
	}
}
