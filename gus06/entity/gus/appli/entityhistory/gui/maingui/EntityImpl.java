package gus06.entity.gus.appli.entityhistory.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150426";}


	private Service tab;
	private Service persist;
	private Service analyzeGui;
	private Service historyGui;
	private Service settingGui;
	private Service debugGui;
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		analyzeGui = Outside.service(this,"*gus.appli.entityhistory.gui.analyze");
		historyGui = Outside.service(this,"*gus.appli.entityhistory.gui.history");
		settingGui = Outside.service(this,"*gus.appli.entityhistory.gui.settings");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		tab.v("GUI_analyze#Analyze",analyzeGui.i());
		tab.v("GUI_history#History",historyGui.i());
		tab.v("GUI_settings#Settings",settingGui.i());
		tab.v("GUI_debug#Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
	}
	
	
	public Object i() throws Exception
	{return tab.i();}
}

