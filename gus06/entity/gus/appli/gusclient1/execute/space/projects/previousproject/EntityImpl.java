package gus06.entity.gus.appli.gusclient1.execute.space.projects.previousproject;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20141028";}


	private Service change;

	public EntityImpl() throws Exception
	{change = Outside.service(this,"gus.appli.gusclient1.project.change");}
	
	
	public void e() throws Exception
	{change.p("-1");}
}
