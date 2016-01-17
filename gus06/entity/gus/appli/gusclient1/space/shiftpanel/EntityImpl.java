package gus06.entity.gus.appli.gusclient1.space.shiftpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gus06.framework.*;

import javax.swing.JComponent;

public class EntityImpl implements Entity, I, ActionListener {

	public String creationDate() {return "20140730";}

	private Service shiftPanel;
	private Service spaceManager;
	private Service spaceBuilder;
	
	
	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		spaceManager = Outside.service(this,"gus.appli.gusclient1.space.manager");
		spaceBuilder = Outside.service(this,"gus.appli.gusclient1.space.builder");
		
		spaceManager.addActionListener(this);
		updateGui();
	}
	
	
	public Object i() throws Exception
	{return shiftPanel.i();}

	

	public void actionPerformed(ActionEvent e)
	{updateGui();}
	
	
	
	
	
	private void updateGui()
	{
		try
		{
			String id = (String) spaceManager.g();
			Object gui = spaceBuilder.t(id);
			shiftPanel.p(gui);
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}
}
