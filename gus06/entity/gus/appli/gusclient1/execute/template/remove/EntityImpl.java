package gus06.entity.gus.appli.gusclient1.execute.template.remove;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140905";}


	private Service holder;
	private Service templateManager;
	private Service confirm;


	public EntityImpl() throws Exception
	{
		holder = Outside.service(this,"gus.appli.gusclient1.gui.template.holder");
		templateManager = Outside.service(this,"gus.appli.gusclient1.template.manager");
		confirm = Outside.service(this,"gus.input.confirm.dialog");
	}
	
	
	public void e() throws Exception
	{
		String id = (String) holder.g();
		if(id==null) return;
		
		boolean ok = confirm.f("Are you sure to delete template: "+id+"?");
		if(ok) templateManager.v(id,null);
	}
}
