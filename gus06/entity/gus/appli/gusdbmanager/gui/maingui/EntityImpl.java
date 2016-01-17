package gus06.entity.gus.appli.gusdbmanager.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150613";}


	private Service tabbedPane;
	private Service bottomBar;
	
	private JPanel panel;



	public EntityImpl() throws Exception
	{
		tabbedPane = Outside.service(this,"gus.appli.gusdbmanager.gui.tabbedpane");
		bottomBar = Outside.service(this,"gus.appli.gusdbmanager.gui.bottombar");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tabbedPane.i(),BorderLayout.CENTER);
		panel.add((JComponent) bottomBar.i(),BorderLayout.SOUTH);
	}
	
	public Object i() throws Exception
	{return panel;}
}