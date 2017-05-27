package gus06.entity.gus.swing.panel.hold.green;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JPanel;
import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140811";}
	
	private JPanel panel;

	
	public EntityImpl() throws Exception
	{
		panel = new JPanel();
		panel.setBackground(Color.GREEN.darker());
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
