package gus06.entity.gus.appli.gusclient1.menu.space.directories;

import java.util.List;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.Action;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140813";}

	public static final String SPACE = "directories";
	public static final String LINGKEY = "gusclient1_space_"+SPACE;


	
	private Service localize;
	private Service custMenu;
	
	private JMenu menu;
	

	public EntityImpl() throws Exception
	{
		localize = Outside.service(this,"gus.ling.localize.manager");
		custMenu = Outside.service(this,"gus.appli.gusclient1.menu.space.cust");
				
		menu = new JMenu("Directories");
		localize.v(LINGKEY,menu);
		custMenu.v(SPACE,menu);
	}
	
	
	
	public Object i() throws Exception
	{return menu;}
	
	
	private void addMenu(Service s) throws Exception
	{
		JMenu m = (JMenu) s.i();
		if(m!=null) menu.add(m);
	}
	
	
	public void addAction(Service s) throws Exception
	{
		Action a = (Action) s.g();
		if(a!=null) menu.add(a);
	}
}
