package gus06.entity.gus.appli.gusclient1.project.deploy.launchjar;

import gus06.framework.*;
import java.io.File;


public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140904";}


	private Service getJarFile;
	private Service launchJar;


	public EntityImpl() throws Exception
	{
		getJarFile = Outside.service(this,"gus.appli.gusclient1.project.deploy.getjar");
		launchJar = Outside.service(this,"gus.java.launchjar");
	}
	
	
	public void e() throws Exception
	{
		File jarFile = (File) getJarFile.g();
		if(jarFile==null || !jarFile.exists()) return;
		
		launchJar.p(jarFile);
	}
}
