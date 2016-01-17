package gus06.entity.gus.appli.laboscript.gui.maingui;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20151130";}


	private Service tab;
	private Service debugGui;
	private Service persist;
	private Service scriptGui;
	
	private JPanel panel;


	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		scriptGui = Outside.service(this,"*gus.appli.laboscript.gui.scriptgui");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		tab.v("FILE_gus#Script",scriptGui.i());
		tab.v("GUI_debug#Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tab.i(),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
