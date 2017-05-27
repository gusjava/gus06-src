package gus06.entity.gus.swing.textcomp.cust.color.shift.background.foreground;

import gus06.framework.*;

import javax.swing.text.JTextComponent;
import java.awt.Color;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170303";}


	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		Color background = comp.getBackground();
		Color foreground = comp.getForeground();
		
		comp.setBackground(foreground);
		comp.setForeground(background);
	}
}
