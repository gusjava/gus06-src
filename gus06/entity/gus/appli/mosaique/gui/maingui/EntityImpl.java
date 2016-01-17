package gus06.entity.gus.appli.mosaique.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141114";}


	private Service tab;
	private Service bottomBar;
	private Service displayPanel;
	private Service settingPanel;
	private Service appViewer;


	private JPanel panel;

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		bottomBar = Outside.service(this,"*gus.appli.mosaique.gui.bottombar");
		displayPanel = Outside.service(this,"*gus.appli.mosaique.gui.display");
		settingPanel = Outside.service(this,"*gus.appli.mosaique.gui.settings");
		appViewer = Outside.service(this,"*gus.app.jarfile.gui.viewer");
		
		tab.v("GUI_display#Affichage",displayPanel.i());
		tab.v("GUI_settings#Options",settingPanel.i());
		tab.v("GUI_java#Code source",appViewer.i());
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tab.i(),BorderLayout.CENTER);
		panel.add((JComponent) bottomBar.i(),BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
