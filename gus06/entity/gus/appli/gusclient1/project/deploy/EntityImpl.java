package gus06.entity.gus.appli.gusclient1.project.deploy;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, E {

	public String creationDate() {return "20140905";}


	private Service updateBuild;
	private Service buildJar;
	private Service initDir;


	public EntityImpl() throws Exception
	{
		updateBuild = Outside.service(this,"gus.appli.gusclient1.project.config.updatebuild");
		buildJar = Outside.service(this,"gus.appli.gusclient1.project.deploy.buildjar");
		initDir = Outside.service(this,"gus.appli.gusclient1.project.deploy.initdir");
	}
	
	
	public void e() throws Exception
	{
		updateBuild.e();
		buildJar.e();
		initDir.e();
		
		complete();
	}
	
	
	private void complete()
	{send(this,"complete()");}
}
