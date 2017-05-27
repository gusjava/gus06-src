package gus06.entity.gus.sys.popup1.displayer;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, P {

	public String creationDate() {return "20161005";}


	private Service gui;
	private Service pack1;
	private Service draggable;
	private Service locationPersister;
	private Service buildController;
	
	private JComponent guiComp;
	private JDialog dialog;
	private E controller;
	
	private List list;


	public EntityImpl() throws Exception
	{
		gui = Outside.service(this,"*gus.sys.popup1.gui.panel");
		pack1 = Outside.service(this,"gus.awt.window.pack1");
		draggable = Outside.service(this,"gus.swing.comp.cust.dragframe");
		locationPersister = Outside.service(this,"gus.swing.dialog.persister.position");
		buildController = Outside.service(this,"gus.sys.popup1.gui.controller");
		
		list = new ArrayList();
		
		guiComp = (JComponent) gui.i();
		
		dialog = new JDialog();
		dialog.setUndecorated(true);
		dialog.setAlwaysOnTop(true);
		dialog.setResizable(false);
		dialog.setContentPane(guiComp);
		dialog.setLocation(10,10);
		dialog.setSize(10,10);
		
		draggable.p(dialog);
		locationPersister.v(getClass().getName()+"_position",dialog);
		
		controller = (E) buildController.t(dialog);
		((S) controller).addActionListener(this);
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map notif = (Map) obj;
		addNotif(notif);
		controller.e();
	}


	public void actionPerformed(ActionEvent e)
	{clearAll();}
	
	
	
	
	private synchronized void addNotif(Map notif)
	{
		try
		{
			list.add(notif);
			gui.p(list);
			pack1.p(dialog);
		}
		catch(Exception e)
		{Outside.err(this,"addNotif(Map)",e);}
	}
	
	
	private synchronized void clearAll()
	{
		try
		{
			list.clear();
			gui.p(list);
			pack1.p(dialog);
		}
		catch(Exception e)
		{Outside.err(this,"clearAll()",e);}
	}
}
