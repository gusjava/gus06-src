package gus06.entity.gus.app.restart0;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150626";}

	
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
}
