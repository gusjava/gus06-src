package gus06.entity.gus.appli.gusclient1.action.entity.toclipboard.name;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, G, E {

	public String creationDate() {return "20140801";}

	public static final String DISPLAY = "Name to clipboard";

	private Service execute;
	private Service buildAction;
	private Service enable;
	
	private Action action;

	
	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.appli.gusclient1.execute.entity.toclipboard.name");
		enable = Outside.service(this,"gus.appli.gusclient1.action.entity.cust.enable");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
		
		action = (Action) buildAction.t(new Object[]{DISPLAY,this});
		enable.p(action);
	}
	
		
	public Object g() throws Exception
	{return action;}
	
	
	public void e() throws Exception
	{execute.e();}
}
