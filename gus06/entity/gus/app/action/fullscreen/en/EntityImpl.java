package gus06.entity.gus.app.action.fullscreen.en;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, G, E {

	public String creationDate() {return "20151015";}

	public static final String DISPLAY = "ACTION_fullScreen#Full screen";
	
	
	
	private Service execute;
	private Service buildAction;
	
	private Action action;
	

	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.app.execute.fullscreen");
		buildAction = Outside.service(this,"gus.swing.action.builder0");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}



	public Object g() throws Exception
	{return action;}
	
	public void e() throws Exception
	{execute.e();}
}
