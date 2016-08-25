package gus06.entity.gus.appli.labomail.gui.maingui;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20160606";}

	private Service tab;
	private Service connectGui;
	private Service storeGui;
	private Service transportGui;
	private Service debugGui;
	private Service persist;
	
	private JPanel panel;


	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		connectGui = Outside.service(this,"*gus.appli.labomail.gui.connect");
		storeGui = Outside.service(this,"*gus.appli.labomail.gui.store");
		transportGui = Outside.service(this,"*gus.appli.labomail.gui.transport");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		tab.v("GUI_connect#Connection",connectGui.i());
		tab.v("GUI_store#Store",storeGui.i());
		tab.v("GUI_transport#Tranport",transportGui.i());
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
			Object store = connectGui.r("store");
			Object transport = connectGui.r("transport");
			
			storeGui.p(store);
			transportGui.p(transport);
		}
		catch(Exception e)
		{Outside.err(this,"connected()",e);}
	}
	
}
