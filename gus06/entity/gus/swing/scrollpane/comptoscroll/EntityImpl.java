package gus06.entity.gus.swing.scrollpane.comptoscroll;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JScrollPane;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140908";}

	
	public Object t(Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		return new JScrollPane(comp);
	}
}
