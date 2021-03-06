package gus06.entity.gus.appli.gusclient1.execute.entity.toclipboard.name;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140801";}


	private Service selection;
	private Service toClipboard;

	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
		toClipboard = Outside.service(this,"gus.clipboard.access.string");
	}
	
	
	public void e() throws Exception
	{
		String name = (String) selection.g();
		if(name==null) return;
		
		toClipboard.p(name);
	}
}
