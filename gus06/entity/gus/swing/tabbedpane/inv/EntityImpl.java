package gus06.entity.gus.swing.tabbedpane.inv;

import gus06.framework.*;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160905";}

	
	
	public Object t(Object obj) throws Exception
	{
		p(obj);
		return obj;
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTabbedPane p = (JTabbedPane) obj;
		int v = p.getTabPlacement();
		
		if(v==JTabbedPane.TOP)
			p.setTabPlacement(JTabbedPane.LEFT);
		else p.setTabPlacement(JTabbedPane.TOP);
	}
}
