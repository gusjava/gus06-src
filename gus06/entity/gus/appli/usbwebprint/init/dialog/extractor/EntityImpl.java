package gus06.entity.gus.appli.usbwebprint.init.dialog.extractor;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


public class EntityImpl implements Entity, ActionListener {

	public String creationDate() {return "20140915";}


	private Service percent;
	private Service buildDialog;
	private Service dialogGui;
	
	private JDialog dialog;



	public EntityImpl() throws Exception
	{
		percent = Outside.service(this,"gus.appli.usbwebprint.usbkey.manager.percent");
		buildDialog = Outside.service(this,"gus.swing.dialog.build.dialogontop");
		dialogGui = Outside.service(this,"gus.appli.usbwebprint.gui.dialog.extractor");
		
		dialog = (JDialog) buildDialog.t(dialogGui.i());
		dialog.setLocation(10,10);
		
		percent.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e)
	{updateGui();}
	
	
	
	
	private void updateGui()
	{
		try
		{
			String value = (String) percent.g();
			dialogGui.p(value);
			dialog.setVisible(value!=null);
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}
}
