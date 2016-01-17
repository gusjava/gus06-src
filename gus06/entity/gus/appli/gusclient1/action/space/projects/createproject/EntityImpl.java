package gus06.entity.gus.appli.gusclient1.action.space.projects.createproject;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, E, G {

	public String creationDate() {return "20140830";}

	public static final String DISPLAY = "Create new project";

	private Service execute;
	private Service buildAction;
	private Action action;
	
	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.appli.gusclient1.execute.space.projects.createproject");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}
	
	
	public Object g() throws Exception
	{return action;}
	
	
	public void e() throws Exception
	{execute.e();}
}
