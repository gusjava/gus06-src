package gus06.entity.gus.swing.panel.rotate180.grid;

import gus06.framework.*;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161126";}


	private Service reverse;

	public EntityImpl() throws Exception
	{
		reverse = Outside.service(this,"gus.swing.panel.reverse");
	}

	
	public Object t(Object obj) throws Exception
	{
		p(obj);
		return obj;
	}
	
	public void p(Object obj) throws Exception
	{
		reverse.p(obj);
	}
}
