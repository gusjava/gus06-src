package gus06.entity.gus.swing.comp.inframe;

import gus06.framework.*;
import javax.swing.*;


public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140803";}


	private Service custFrame;

	public EntityImpl() throws Exception
	{
		custFrame = Outside.service(this,"gus.swing.frame.cust2.display");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		if(comp instanceof Scrollable)
			comp = new JScrollPane(comp);
		
		JFrame frame = new JFrame();
		custFrame.v(key,frame);
		
		frame.setContentPane(comp);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
