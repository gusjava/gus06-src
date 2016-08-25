package gus06.entity.gus.appli.gusgadgets.gui.maingui;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160420";}


	private Service manager;


	private JPanel panel;

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusgadgets.manager");
		
		panel = new JPanel(new BorderLayout());
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
