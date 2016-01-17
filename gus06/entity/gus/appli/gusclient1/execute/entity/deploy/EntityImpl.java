package gus06.entity.gus.appli.gusclient1.execute.entity.deploy;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140801";}


	private Service selection;
	private Service deploy;

	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
		deploy = Outside.service(this,"gus.entitydev.deploy.buildjar");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) selection.g();
		if(name==null) return;
		
		deploy.p(name);
	}
}
