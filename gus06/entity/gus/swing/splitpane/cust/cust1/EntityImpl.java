package gus06.entity.gus.swing.splitpane.cust.cust1;

import gus06.framework.*;
import javax.swing.JSplitPane;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140917";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		JSplitPane split = (JSplitPane) obj;
		split.setDividerSize(3);
	}
}
