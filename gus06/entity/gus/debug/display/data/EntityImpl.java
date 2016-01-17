package gus06.entity.gus.debug.display.data;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.JComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140915";}


	private Service viewer;

	
	private JFrame frame;

	public EntityImpl() throws Exception
	{
		viewer = Outside.service(this,"*gus.data.viewer.object");
		
		frame = new JFrame("DEBUG VIEWER");
		frame.setContentPane((JComponent) viewer.i());
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	
	public void p(Object obj) throws Exception
	{
		viewer.p(obj);
	}
}
