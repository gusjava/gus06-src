package gus06.entity.gus.appli.gusjavatoolbox.gui.maingui;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160501";}


	private Service tab;
	private Service persist;
	private Service debugGui;
	
	private Service gui_codePoints;


	private JPanel panel;
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		
		gui_codePoints = Outside.service(this,"*gus.appli.gusjavatoolbox.gui.codepoint");
		
		
		tab.v("GUI_codePoints#Code points",gui_codePoints.i());
		tab.v("GUI_debug#Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tab.i(),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
