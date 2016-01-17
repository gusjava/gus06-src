package gus06.entity.gus.appli.gusclient1.execute.entity.execute;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140809";}


	private Service selection;
	private Service execute;

	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
		execute = Outside.service(this,"gus.app.entity.executenew");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) selection.g();
		if(name==null) return;
		
		execute.p(name);
	}
}
