package gus06.entity.gus.appli.gusexplorer.menu.tools.scripts;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20160909";}


	private Service manager;
	private Service repaintButton;
	
	
	private JMenu1 menu;
	private Map map;
	

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.scripts.tools.manager");
		repaintButton = Outside.service(this,"gus.swing.button.cust2.display");
		
		menu = new JMenu1("Scripts");
		map = new HashMap();
		
		updateMenu();
		manager.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{updateMenu();}
	
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	
	private void updateMenu()
	{
		try
		{
			menu.removeAll();
			
			List names = (List) manager.g();
			for(int i=0;i<names.size();i++)
			{
				String name = (String) names.get(i);
				JMenuItem1 item = findItem(name);
				menu.add(item);
			}
			
			menu.updateMenu();
		}
		catch(Exception e)
		{Outside.err(this,"updateMenu()",e);}
	}
	
	
	
	
	private JMenuItem1 findItem(String name) throws Exception
	{
		if(!map.containsKey(name)) map.put(name,new JMenuItem1(name));
		return (JMenuItem1) map.get(name);
	}
	
	
	
	
	
	private void executeScript(String name)
	{
		try{manager.p(name);}
		catch(Exception e)
		{Outside.err(this,"executeScript(String)",e);}
	}
	
	
	private class JMenuItem1 extends JMenuItem implements ActionListener, Runnable
	{
		private String name;
		public JMenuItem1(String name) throws Exception
		{
			super();
			this.name = name;
			repaintButton.v("FILE_gus#"+name,this);
			addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		{new Thread(this,"THREAD_"+getClass().getName()).start();}
		
		public void run()
		{executeScript(name);}
	}
	
	
	
	private class JMenu1 extends JMenu 
	{
		public JMenu1(String title)
		{
			super(title);
		}
		
		public void updateMenu()
		{
			synchronized(getTreeLock())
			{validateTree();}

			if(isDisplayable())
			{
				validate();
				repaint();
			}
		}
	}
}
