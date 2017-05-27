package gus06.entity.gus.app.action.help.en;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, E, G {

	public String creationDate() {return "20160919";}

	public static final String DISPLAY = "ACTION_help#Help";



	private Service execute;
	private Service buildAction;
	
	private Action action;
	
	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.app.execute.help");
		buildAction = Outside.service(this,"gus.swing.action.builder0");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}
	
	
		
	public Object g() throws Exception
	{return action;}
	
	public void e() throws Exception
	{execute.e();}
}
