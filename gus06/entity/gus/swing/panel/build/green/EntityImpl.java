package gus06.entity.gus.swing.panel.build.green;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

import gus06.framework.Entity;
import gus06.framework.I;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140629";}
	
	public Object i() throws Exception
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN.darker());
		return panel;
	}
}
