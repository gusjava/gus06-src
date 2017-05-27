package gus06.entity.gus.swing.action.sum;

import gus06.framework.*;
import javax.swing.Action;
import javax.swing.JToolBar;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170314";}


	private Service build;

	public EntityImpl() throws Exception
	{
		build = Outside.service(this,"gus.swing.toolbar.toolbar1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Action[] o = (Action[]) obj;
		
		JToolBar bar = (JToolBar) build.i();
		
		for(int i=0;i<o.length;i++)
		bar.add(o[i]);
		
		return bar;
	}
}
