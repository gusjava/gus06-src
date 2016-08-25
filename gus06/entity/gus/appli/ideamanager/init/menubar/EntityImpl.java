package gus06.entity.gus.appli.ideamanager.init.menubar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20151013";}
	
	
	private Service bar;
	private JMenuBar menuBar;


	public EntityImpl() throws Exception
	{
		bar = Outside.service(this,"gus.app.mainframe.menubar");
		menuBar = (JMenuBar) bar.i();
		
		add(Outside.service(this,"gus.appli.ideamanager.menu.menu1"));
		
		menuBar.repaint();
	}
	
	
	
	
	private void add(Service s)
	{
		try
		{
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
