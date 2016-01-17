package gus06.entity.gus.appli.gusclient1.execute.gus.testapp;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140811";}

	private Service cmd1;
	private Service cmd2;

	public EntityImpl() throws Exception
	{
		cmd1 = Outside.service(this,"gus.command.rebuild.other");
		cmd2 = Outside.service(this,"gus.app.jarfile.o.launch");
	}
	
	public void e() throws Exception
	{
		cmd1.e();
		cmd2.e();
	}
}