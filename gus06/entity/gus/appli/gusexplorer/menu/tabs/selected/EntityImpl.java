package gus06.entity.gus.appli.gusexplorer.menu.tabs.selected;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20151006";}

	private Service reload;
	private Service moveUp;
	private Service runTask;
	private Service toClipboard;
	private Service browseParent;
	
	private JMenu menu;

	public EntityImpl() throws Exception
	{
		reload = Outside.service(this,"gus.appli.gusexplorer.action.tabs.selected.reload");
		moveUp = Outside.service(this,"gus.appli.gusexplorer.action.tabs.selected.moveup");
		runTask = Outside.service(this,"gus.appli.gusexplorer.action.tabs.selected.runtask");
		toClipboard = Outside.service(this,"gus.appli.gusexplorer.action.tabs.selected.toclipboard");
		browseParent = Outside.service(this,"gus.appli.gusexplorer.action.tabs.selected.browseparent");
	
		menu = new JMenu("Selected tab");
		
		add(reload);
		add(moveUp);
		add(runTask);
		add(toClipboard);
		add(browseParent);
	}
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
