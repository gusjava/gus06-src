package gus06.entity.gus.app.restart;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140705";}

	
	private Service findJar;
	private Service findArgs;
	private Service launchJar;

	public EntityImpl() throws Exception
	{
		findJar = Outside.service(this,"gus.app.jarfile");
		findArgs = Outside.service(this,"gus.app.argsline");
		launchJar = Outside.service(this,"gus.java.launchjar");
	}
	
	
	public void e() throws Exception
	{
		File jar = (File) findJar.g();
		String args = (String) findArgs.g();
		launchJar.p(new Object[]{jar,args});
		
		System.exit(0);
	}
}
