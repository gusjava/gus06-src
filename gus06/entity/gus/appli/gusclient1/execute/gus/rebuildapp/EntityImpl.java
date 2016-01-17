package gus06.entity.gus.appli.gusclient1.execute.gus.rebuildapp;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140811";}

	private Service backup;
	private Service rebuild;

	public EntityImpl() throws Exception
	{
		backup = Outside.service(this,"gus.command.backupapp");
		rebuild = Outside.service(this,"gus.command.rebuild");
	}
	
	public void e() throws Exception
	{
		backup.e();
		rebuild.e();
	}
}
