package gus06.entity.gus.appli.appliaccess.gui.maingui;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150313";}


	private Service tab;
	private Service bottomBar;
	private Service downloadGui;
	private Service settingGui;
	private Service debugGui;
	private Service persist;


	private JPanel panel;
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		bottomBar = Outside.service(this,"*gus.appli.appliaccess.gui.bottombar");
		downloadGui = Outside.service(this,"*gus.appli.appliaccess.gui.download");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		settingGui = Outside.service(this,"*gus.appli.appliaccess.gui.settings");
		
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		
		tab.v("GUI_download#Download all",downloadGui.i());
		tab.v("GUI_settings#Settings",settingGui.i());
		tab.v("GUI_debug#Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
		
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tab.i(),BorderLayout.CENTER);
		panel.add((JComponent) bottomBar.i(),BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
