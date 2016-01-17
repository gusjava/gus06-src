package gus06.entity.gus.appli.entitytester.gui.maingui;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150920";}


	private Service tab;
	private Service debugGui;
	private Service persist;
	private Service gui1;
	
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		gui1 = Outside.service(this,"*gus.appli.entitytester.gui.stringtransform");
		
		
		tab.v("GUI_stringTransform#String transform",gui1.i());
		tab.v("GUI_debug#Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
	}
	
	
	public Object i() throws Exception
	{return tab.i();}
}
