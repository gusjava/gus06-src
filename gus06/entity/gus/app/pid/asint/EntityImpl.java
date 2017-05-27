package gus06.entity.gus.app.pid.asint;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170410";}


	private Service find;


	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.app.pid");
	}
	
	public Object g() throws Exception
	{
		String pid = (String) find.g();
		return new Integer(pid);
	}
}
