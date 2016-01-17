package gus06.entity.gus.appli.gusclient1.execute.space.projects.releaseproject;

import gus06.framework.*;
import java.util.HashMap;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20141014";}


	private Service release;


	public EntityImpl() throws Exception
	{
		release = Outside.service(this,"gus.appli.gusclient1.project.release");
	}
	
	public void e() throws Exception
	{
		release.e();
	}
}
