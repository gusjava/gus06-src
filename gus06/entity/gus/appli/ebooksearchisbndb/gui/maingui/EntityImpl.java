package gus06.entity.gus.appli.ebooksearchisbndb.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150509";}


	private Service tab;
	private Service bottomBar;
	private Service searchGui;
	private Service settingGui;
	private Service persist;
	private Service debugGui;


	private JPanel panel;
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		bottomBar = Outside.service(this,"*gus.appli.ebooksearchisbndb.gui.bottombar");
		searchGui = Outside.service(this,"*gus.appli.ebooksearchisbndb.gui.search");
		settingGui = Outside.service(this,"*gus.appli.ebooksearchisbndb.gui.settings");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		
		tab.v("GUI_search#Search for ebooks",searchGui.i());
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
