package gus06.entity.gus.appli.gusexplorer.execute.tabs.selected.moveup;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151006";}


	private Service manager;
	private Service selection;
	private Service threadHandler;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		selection = Outside.service(this,"gus.appli.gusexplorer.gui.tabbedpane.selection");
		threadHandler = Outside.service(this,"gus.feature.thread.v");
	}
	
	
	public void e() throws Exception
	{
		File selected = (File) selection.g();
		if(selected==null) return;
		
		File parent = selected.getParentFile();
		if(parent==null) return;
		
		File[] data = new File[]{selected,parent};
		threadHandler.p(new Object[]{manager,"modify",data});
	}
}
