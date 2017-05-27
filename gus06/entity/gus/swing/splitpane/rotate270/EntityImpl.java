package gus06.entity.gus.swing.splitpane.rotate270;

import gus06.framework.*;
import javax.swing.JSplitPane;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161126";}


	private Service reverse;

	public EntityImpl() throws Exception
	{
		reverse = Outside.service(this,"gus.swing.splitpane.reverse");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		p(obj);
		return obj;
	}
	
	
	public void p(Object obj) throws Exception
	{
		JSplitPane split = (JSplitPane) obj;
		int v = split.getOrientation();
		
		if(v==JSplitPane.HORIZONTAL_SPLIT)
		{
			split.setOrientation(JSplitPane.VERTICAL_SPLIT);
			reverse.p(split);
		}
		else
		{
			split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		}
	}
}
