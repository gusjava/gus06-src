package gus06.entity.gus.app.restart;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, P, E {

	public String creationDate() {return "20140705";}

	
	private Service findJar;
	private Service launchJar;

	public EntityImpl() throws Exception
	{
		findJar = Outside.service(this,"gus.app.jarfile");
		launchJar = Outside.service(this,"gus.java.launchjar");
	}
	
	
	public void e() throws Exception
	{
		File jar = (File) findJar.g();
		launchJar.p(jar);
		System.exit(0);
	}
	
	public void p(Object obj) throws Exception
	{
		String args = (String) obj;
		File jar = (File) findJar.g();
		launchJar.p(new Object[]{jar,args});
		System.exit(0);
	}
}
