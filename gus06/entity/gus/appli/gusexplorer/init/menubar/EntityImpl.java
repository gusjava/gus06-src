package gus06.entity.gus.appli.gusexplorer.init.menubar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20151002";}
	
	
	private Service bar;
	private JMenuBar menuBar;


	public EntityImpl() throws Exception
	{
		bar = Outside.service(this,"gus.app.mainframe.menubar");
		menuBar = (JMenuBar) bar.i();
		
		add("gus.appli.gusexplorer.menu.menu1");
		add("gus.appli.gusexplorer.menu.config");
		add("gus.appli.gusexplorer.menu.tabs");
		add("gus.appli.gusexplorer.menu.tools");
		
		menuBar.repaint();
	}
	
	
	
	
	private void add(String entityName)
	{
		try
		{
			Service s = Outside.service(this,entityName);
			JMenu menu = (JMenu) s.i();
			if(menu!=null) menuBar.add(menu);
		}
		catch(Exception e)
		{
			Outside.err(this,"add(String)",e);
			menuBar.add(new JMenu("###"));
		}
	}
}
