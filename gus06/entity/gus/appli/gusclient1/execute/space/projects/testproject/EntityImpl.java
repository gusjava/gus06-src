package gus06.entity.gus.appli.gusclient1.execute.space.projects.testproject;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140904";}


	private Service manager;
	private Service launch;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		launch = Outside.service(this,"gus.appli.gusclient1.project.deploy.launchjar");
	}
	
	
	public void e() throws Exception
	{
		String id = (String) manager.g();
		if(id==null || id.equals("")) return;
		launch.p(id);
	}
}
