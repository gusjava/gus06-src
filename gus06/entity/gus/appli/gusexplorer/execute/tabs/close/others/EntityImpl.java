package gus06.entity.gus.appli.gusexplorer.execute.tabs.close.others;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151005";}


	private Service manager;
	private Service selection;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		selection = Outside.service(this,"gus.appli.gusexplorer.gui.tabbedpane.selection");
	}
	
	
	public void e() throws Exception
	{
		File selected = (File) selection.g();
		if(selected==null) return;
		
		manager.v("keep",selected);
	}
}
