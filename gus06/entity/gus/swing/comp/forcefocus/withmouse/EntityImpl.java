package gus06.entity.gus.swing.comp.forcefocus.withmouse;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JComponent;
import javax.swing.JDialog;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160916";}


	private Service forceJFrame;
	private Service forceJDialog;
	private Service mouseOrder;


	public EntityImpl() throws Exception
	{
		forceJFrame = Outside.service(this,"gus.swing.frame.forcefocus.withmouse");
		forceJDialog = Outside.service(this,"gus.swing.dialog.forcefocus.withmouse");
		mouseOrder = Outside.service(this,"gus.awt.robot.mouse.order");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		Object ancestor = SwingUtilities.getWindowAncestor(comp);
		
		if(ancestor instanceof JFrame)
		{
			JFrame frame = (JFrame) ancestor;
			if(!frame.isVisible()) return;
			forceJFrame.p(frame);
			comp.requestFocusInWindow();
			return;
		}
			
		if(ancestor instanceof JDialog)
		{
			JDialog dialog = (JDialog) ancestor;
			if(!dialog.isVisible()) return;
			forceJDialog.p(dialog);
			comp.requestFocusInWindow();
			return;
		}
	}
}
