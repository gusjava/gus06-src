package gus06.entity.gus.app.action.setting;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, E, G {

	public String creationDate() {return "20170512";}

	public static final String DISPLAY = "ACTION_setting#Settings";



	private Service execute;
	private Service buildAction;
	
	private Action action;
	
	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.app.execute.setting");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}
	
	
		
	public Object g() throws Exception
	{return action;}
	
	public void e() throws Exception
	{execute.e();}
}
