package gus06.entity.gus.appli.gusclient1.menu.about;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140718";}

	private Service console;
	private Service about;
	private Service exit;
	
	private JMenu menu;

	public EntityImpl() throws Exception
	{
		console = Outside.service(this,"gus.appli.gusclient1.action.console");
		about = Outside.service(this,"gus.app.action.about");
		exit = Outside.service(this,"gus.app.action.exit");
	
		menu = new JMenu("?");
		
		add(console);
		add(exit);
		menu.addSeparator();
		add(about);
	}
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
