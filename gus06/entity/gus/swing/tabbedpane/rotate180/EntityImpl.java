package gus06.entity.gus.swing.tabbedpane.rotate180;

import gus06.framework.*;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161126";}

	
	
	public Object t(Object obj) throws Exception
	{
		p(obj);
		return obj;
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTabbedPane p = (JTabbedPane) obj;
		// A FAIRE
	}
}
