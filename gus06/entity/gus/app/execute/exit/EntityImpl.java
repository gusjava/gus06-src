package gus06.entity.gus.app.execute.exit;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, E {

	public String creationDate() {return "20140803";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void e() throws Exception
	{
		send(this,"exit");
		System.exit(0);
	}
}
