package gus06.entity.gus.appli.usbwebprint.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140902";}


	private JPanel panel;

	public EntityImpl() throws Exception
	{
		panel = new JPanel(new BorderLayout());
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
