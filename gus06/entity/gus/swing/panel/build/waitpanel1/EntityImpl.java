package gus06.entity.gus.swing.panel.build.waitpanel1;

import gus06.framework.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.GridBagLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141028";}
	
	private Icon icon;
	
	public EntityImpl() throws Exception
	{icon = (Icon) Outside.resource(this,"icon#WAIT_big1");}

	
	public Object i() throws Exception
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.add(new JLabel(icon));
		return panel;
	}
}
