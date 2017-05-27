package gus06.entity.gus.appli.gusexplorer.menu.menu1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20151002";}

	private Service fullscreen;
	private Service setting;
	private Service about;
	private Service help;
	private Service exit;
	
	private JMenu menu;

	public EntityImpl() throws Exception
	{
		fullscreen = Outside.service(this,"gus.app.action.fullscreen.en");
		setting = Outside.service(this,"gus.app.action.setting.en");
		about = Outside.service(this,"gus.app.action.about.en");
		help = Outside.service(this,"gus.app.action.help.en");
		exit = Outside.service(this,"gus.app.action.exit.en");
	
		menu = new JMenu("Application");
		
		add(fullscreen);
		add(setting);
		add(help);
		add(about);
		menu.addSeparator();
		add(exit);
	}
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	
	public void add(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
