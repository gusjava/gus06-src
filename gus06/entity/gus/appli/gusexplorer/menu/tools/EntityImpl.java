package gus06.entity.gus.appli.gusexplorer.menu.tools;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160909";}

	
	private Service menu_scripts;
	private Service remote;
	
	private JMenu menu;


	public EntityImpl() throws Exception
	{
		menu_scripts = Outside.service(this,"gus.appli.gusexplorer.menu.tools.scripts");
		remote = Outside.service(this,"gus.appli.gusexplorer.action.tools.script.remote");
	
		menu = new JMenu("Tools");
		menu.add((JMenu) menu_scripts.i());
		
		add(remote);
	}
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
