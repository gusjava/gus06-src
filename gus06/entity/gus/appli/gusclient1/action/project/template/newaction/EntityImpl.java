package gus06.entity.gus.appli.gusclient1.action.project.template.newaction;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, G, E {

	public String creationDate() {return "20140905";}

	public static final String DISPLAY = "Action template";


	private Service execute;
	private Service buildAction;
	
	private Action action;

	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.appli.gusclient1.execute.project.template.newaction");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
	}
	
		
	public Object g() throws Exception
	{return action;}
	
	
	public void e() throws Exception
	{execute.e();}
}
