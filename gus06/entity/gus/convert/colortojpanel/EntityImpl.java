package gus06.entity.gus.convert.colortojpanel;

import gus06.framework.*;
import javax.swing.JPanel;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}

	
	public Object t(Object obj) throws Exception
	{
		Color c = (Color) obj;
		
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setBackground(c);
		return panel;
	}
}
