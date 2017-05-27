package gus06.entity.gus.app.execute.help;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.JComponent;

public class EntityImpl extends S1 implements Entity, E {

	public String creationDate() {return "20160919";}

	public static final String DISPLAY = "ACTION_help#Help";

	private Service custFrame;
	private Service helpPanel;
	
	private JFrame frame;
	


	public EntityImpl() throws Exception
	{
		custFrame = Outside.service(this,"gus.swing.frame.cust2.display");
		helpPanel = Outside.service(this,"*gus.app.execute.help.panel");
		
		JComponent comp = (JComponent) helpPanel.i();
		
		frame = new JFrame();
		frame.setSize(1200,800);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(comp);
		
		custFrame.v(DISPLAY,frame);
	}
	
	
	public void e() throws Exception
	{
		frame.setVisible(true);
	}
}
