package gus06.entity.gus.debug.gui.maingui.show;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.JComponent;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20170408";}


	private Service gui;

	public EntityImpl() throws Exception
	{
		gui = Outside.service(this,"*gus.debug.gui.maingui");
	}
	
	public void e() throws Exception
	{
		JFrame frame = new JFrame("Debug");
		frame.setContentPane((JComponent) gui.i());
		frame.setSize(500,300);
		frame.setVisible(true);
	}
}
