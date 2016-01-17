package gus06.entity.gus.appli.gusexplorer.menu.tabs.add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20151006";}

	
	private Service addFromClipboard;
	private Service addTxtFile;
	private Service addTempDir;
	
	private Service addRoots;
	private Service addDesktop;
	
	
	private JMenu menu;

	public EntityImpl() throws Exception
	{
		addFromClipboard = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.temp.fromclipboard");
		addTxtFile = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.temp.emptytxtfile");
		addTempDir = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.temp.dir");
		
		addRoots = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.roots");
		addDesktop = Outside.service(this,"gus.appli.gusexplorer.action.tabs.add.desktop");
	
		menu = new JMenu("Add new tabs");
		
		add(addFromClipboard);
		add(addTxtFile);
		add(addTempDir);
		
		menu.addSeparator();
		
		add(addRoots);
		add(addDesktop);
	}
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
