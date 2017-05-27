package gus06.entity.gus.appli.gusexplorer.menu.tabs.add;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20151006";}

	
	private Service addFromClipboard;
	private Service addFromClipboardAsPath;
	private Service addTxtFile;
	
	private Service addTempDir;
	private Service addIconDir;
	private Service addAppRootDir;
	private Service addScriptDir_h;
	private Service addScriptDir_tools;
	private Service addScriptDir_startup;
	
	private Service addRoots;
	private Service addDesktop;
	private Service addStartup;
	
	
	private JMenu menu;

	public EntityImpl() throws Exception
	{
		addFromClipboard = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.fromclipboard");
		addFromClipboardAsPath = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.fromclipboard.aspath");
		addTxtFile = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.temp.emptytxtfile");
		
		addTempDir = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.temp.dir");
		addIconDir = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.icondir");
		addAppRootDir = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.approotdir");
		addScriptDir_h = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.scriptdir.h");
		addScriptDir_tools = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.scriptdir.tools");
		addScriptDir_startup = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.scriptdir.startup");
		
		addRoots = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.roots");
		addDesktop = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.desktop");
		addStartup = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.startup");
	
		menu = new JMenu("Add new tabs");
		
		add(addFromClipboard);
		add(addFromClipboardAsPath);
		add(addTxtFile);
		
		menu.addSeparator();
		
		add(addAppRootDir);
		add(addTempDir);
		add(addIconDir);
		
		menu.addSeparator();
		
		add(addScriptDir_h);
		add(addScriptDir_tools);
		add(addScriptDir_startup);
		
		menu.addSeparator();
		
		add(addRoots);
		add(addDesktop);
		add(addStartup);
	}
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
