package gus06.entity.gus.appli.ideamanager.action.open.backupdir;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, G, E {

	public String creationDate() {return "20151013";}

	public static final String DISPLAY = "ACTION_openBackupDir#Open backup dir";

	private Service execute;
	private Service buildAction;
	private Action action;

	
	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.appli.ideamanager.execute.open.backupdir");
		buildAction = Outside.service(this,"gus.swing.action.builder0");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}
	
		
	public Object g() throws Exception
	{return action;}
	
	
	public void e() throws Exception
	{execute.e();}
}
