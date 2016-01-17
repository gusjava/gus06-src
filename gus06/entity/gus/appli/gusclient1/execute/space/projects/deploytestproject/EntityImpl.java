package gus06.entity.gus.appli.gusclient1.execute.space.projects.deploytestproject;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140912";}


	private Service deploy;
	private Service launch;


	public EntityImpl() throws Exception
	{
		deploy = Outside.service(this,"gus.appli.gusclient1.project.deploy");
		launch = Outside.service(this,"gus.appli.gusclient1.project.deploy.launchjar");
	}
	
	
	public void e() throws Exception
	{
		deploy.e();
		launch.e();
	}
}
