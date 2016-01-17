package gus06.entity.gus.appli.gusclient1.execute.gus.extractall;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140815";}

	private Service cmd;

	public EntityImpl() throws Exception
	{cmd = Outside.service(this,"gus.app.jarfile.extract1");}
	
	public void e() throws Exception
	{cmd.e();}
}
