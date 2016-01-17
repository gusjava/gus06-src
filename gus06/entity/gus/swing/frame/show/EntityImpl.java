package gus06.entity.gus.swing.frame.show;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151001";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		
		JFrame frame = new JFrame();
		frame.setContentPane(comp);
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
