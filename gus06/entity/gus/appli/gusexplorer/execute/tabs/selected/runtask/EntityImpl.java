package gus06.entity.gus.appli.gusexplorer.execute.tabs.selected.runtask;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151006";}


	private Service runtask;
	private Service selection;
	private Service threadHandler;


	public EntityImpl() throws Exception
	{
		runtask = Outside.service(this,"gus.sys.runtask1.input.path");
		selection = Outside.service(this,"gus.appli.gusexplorer.gui.tabbedpane.selection");
		threadHandler = Outside.service(this,"gus.feature.thread.p");
	}
	
	
	public void e() throws Exception
	{
		File selected = (File) selection.g();
		if(selected==null) return;
		
		threadHandler.p(new Object[]{runtask,selected});
	}
}
