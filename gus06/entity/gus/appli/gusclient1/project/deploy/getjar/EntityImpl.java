package gus06.entity.gus.appli.gusclient1.project.deploy.getjar;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140902";}

	private Service idToFile;
	private Service manager;


	public EntityImpl() throws Exception
	{
		idToFile = Outside.service(this,"gus.appli.gusclient1.project.idtofile.deploy.jar");
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
	}
	
	public Object g() throws Exception
	{
		String id = (String) manager.g();
		if(id==null) return null;
		return idToFile.t(id);
	}
}
