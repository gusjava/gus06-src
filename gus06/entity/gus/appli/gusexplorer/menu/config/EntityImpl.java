package gus06.entity.gus.appli.gusexplorer.menu.config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.util.List;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingUtilities;
import java.util.Map;
import java.util.HashMap;


public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20160419";}


	private Service configManager;
	private Service actionCreate;

	
	private JMenu1 menu;
	private Map map;
	

	public EntityImpl() throws Exception
	{
		configManager = Outside.service(this,"gus.appli.gusexplorer.config.manager");
		actionCreate = Outside.service(this,"gus.appli.gusexplorer.action.config.create");
		
		menu = new JMenu1("Config");
		map = new HashMap();
		
		updateMenu();
		configManager.addActionListener(this);
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
		
			List names = (List) configManager.r("names");
			String name0 = (String) configManager.r("name");
			
			ButtonGroup group = new ButtonGroup();
			
			for(int i=0;i<names.size();i++)
			{
				String name = (String) names.get(i);
				boolean selected = name.equals(name0);
				
				JRadioButtonMenuItem1 item = findItem(name);
				item.setSelected(selected);
				
				group.add(item);
				menu.add(item);
			}
			
			menu.addSeparator();
			add(actionCreate);
			
			menu.updateMenu();
		}
		catch(Exception e)
		{Outside.err(this,"updateMenu()",e);}
	}
	
	
	
	private JRadioButtonMenuItem1 findItem(String name)
	{
		if(!map.containsKey(name)) map.put(name,new JRadioButtonMenuItem1(name));
		return (JRadioButtonMenuItem1) map.get(name);
	}
	
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
	
	private void changeConfig(String name)
	{
		//System.out.println("change config: "+name);
		try{configManager.p(name);}
		catch(Exception e)
		{Outside.err(this,"changeConfig(String)",e);}
	}
	
	
	private class JRadioButtonMenuItem1 extends JRadioButtonMenuItem implements ChangeListener, Runnable
	{
		private String name;
		public JRadioButtonMenuItem1(String name)
		{
			super(name);
			this.name = name;
			addChangeListener(this);
		}
		
		public void stateChanged(ChangeEvent e)
		{
			//System.out.println("stateChanged for item: "+name);
			if(isSelected())
			SwingUtilities.invokeLater(this);
		}
		
		public void run()
		{changeConfig(name);}
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
