package gus06.entity.gus.swing.panel.rotate270.grid;

import gus06.framework.*;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161126";}


	private Service inv;

	public EntityImpl() throws Exception
	{
		inv = Outside.service(this,"gus.swing.panel.inv.grid");
	}

	
	public Object t(Object obj) throws Exception
	{
		p(obj);
		return obj;
	}
	
	public void p(Object obj) throws Exception
	{
		inv.p(obj);
	}
}
