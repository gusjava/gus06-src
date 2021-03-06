package gus06.entity.gus.appli.gusexplorer.action.tabs.close.selected;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, G, E {

	public String creationDate() {return "20151005";}

	public static final String DISPLAY = "ACTION_tab_closeSelected#Close selected";

	private Service execute;
	private Service buildAction;
	private Action action;

	
	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.appli.gusexplorer.execute.tabs.close.selected");
		buildAction = Outside.service(this,"gus.swing.action.builder0");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}
	
		
	public Object g() throws Exception
	{return action;}
	
	
	public void e() throws Exception
	{execute.e();}
}
