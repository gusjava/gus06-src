package gus06.entity.gus.app.restart0;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150626";}

	
	private Service findArgs;
	private Service restart;

	public EntityImpl() throws Exception
	{
		findArgs = Outside.service(this,"gus.app.argsline");
		restart = Outside.service(this,"gus.app.restart");
	}
	
	
	public void e() throws Exception
	{
		String args = (String) findArgs.g();
		restart.p(args);
	}
}
