package gus06.entity.gus.appli.gusclient1.execute.template.rename;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140905";}


	private Service holder;
	private Service templateManager;
	private Service input;


	public EntityImpl() throws Exception
	{
		holder = Outside.service(this,"gus.appli.gusclient1.gui.template.holder");
		templateManager = Outside.service(this,"gus.appli.gusclient1.template.manager");
		input = Outside.service(this,"gus.input.text.dialog");
	}
	
	
	public void e() throws Exception
	{
		String id = (String) holder.g();
		if(id==null) return;
		
		String newId = (String) input.t(new String[]{"Please, enter new template id",id});
		if(newId==null) return;
		
		String template = (String) templateManager.r(id);
		templateManager.v(id,null);
		templateManager.v(newId,template);
	}
}
