package gus06.entity.gus.app.mainframe.menubar;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140718";}


	private JFrame frame;
	private JMenuBar menuBar;
	
	public EntityImpl() throws Exception
	{frame = (JFrame) Outside.resource(this,"mainframe");}
	
	
	
	public Object i() throws Exception
	{
		if(menuBar==null) init();
		return menuBar;
	}
	
	
	private void init()
	{
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	}
}
