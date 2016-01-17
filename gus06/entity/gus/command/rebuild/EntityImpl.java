package gus06.entity.gus.command.rebuild;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140716";}

	private Service updateBuild;
	private Service rebuildJar;

	public EntityImpl() throws Exception
	{
		updateBuild = Outside.service(this,"gus.appdev.updatebuild");
		rebuildJar = Outside.service(this,"gus.app.jarfile.rebuild1");
	}
	
	
	public void e() throws Exception
	{
		updateBuild.e();
		rebuildJar.e();
		
		System.exit(0);
	}
}
