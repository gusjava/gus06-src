package gus06.entity.gus.appli.labojdbc.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150621";}


	private Service tab;
	private Service connectGui;
	private Service viewGui;
	private Service userGui;
	private Service sqlGui;
	private Service varGui;
	private Service infoGui;
	private Service debugGui;
	private Service persist;
	
	private JPanel panel;
	
	
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		connectGui = Outside.service(this,"*gus.appli.labojdbc.gui.connect");
		viewGui = Outside.service(this,"*gus.jdbc.gui.cx1");
		userGui = Outside.service(this,"*gus.jdbc.gui.user1");
		sqlGui = Outside.service(this,"*gus.jdbc.gui.sqlquery1");
		varGui = Outside.service(this,"*gus.jdbc.gui.var1");
		infoGui = Outside.service(this,"*gus.jdbc.gui.infoarea1");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		tab.v("GUI_connect#Connection",connectGui.i());
		tab.v("GUI_view#Databases",viewGui.i());
		tab.v("GUI_user#Users",userGui.i());
		tab.v("GUI_variable#Variables",varGui.i());
		tab.v("GUI_info#Informations",infoGui.i());
		tab.v("GUI_sql#SQL query",sqlGui.i());
		tab.v("GUI_debug#Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tab.i(),BorderLayout.CENTER);
		
		connectGui.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return panel;}


	public void actionPerformed(ActionEvent e)
	{connected();}
	
	
	
	
	private void connected()
	{
		try
		{
			Object holder = connectGui.g();
			
			viewGui.p(holder);
			userGui.p(holder);
			sqlGui.p(holder);
			varGui.p(holder);
			infoGui.p(holder);
		}
		catch(Exception e)
		{Outside.err(this,"connected()",e);}
	}

}
