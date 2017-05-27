package gus06.entity.gus.appli.gusexplorer.execute.tabs.selected.toclipboard;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20160904";}


	private Service perform;
	private Service selection;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.clipboard.access.file");
		selection = Outside.service(this,"gus.appli.gusexplorer.gui.tabbedpane.selection");
	}
	
	
	public void e() throws Exception
	{
		File selected = (File) selection.g();
		if(selected==null) return;
		
		perform.p(selected);
	}
}
