package gus06.entity.gus.appli.gusexplorer.gui.bottombar;

import gus06.framework.*;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150609";}


	private Service taskLabel;
	private Service clipboardLabel;

	
	private JPanel panel;

	public EntityImpl() throws Exception
	{
		taskLabel = Outside.service(this,"*gus.sys.runtask1.label1");
		clipboardLabel = Outside.service(this,"*gus.sys.clipboard1.gui.displaylabel1");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) taskLabel.i(),BorderLayout.WEST);
		panel.add((JComponent) clipboardLabel.i(),BorderLayout.EAST);
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
