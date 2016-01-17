package gus06.entity.gus.appli.gusclient1.execute.gus.killtest;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140811";}

	private Service cmd;

	public EntityImpl() throws Exception
	{cmd = Outside.service(this,"gus.app.jarfile.o.process");}
	
	public void e() throws Exception
	{cmd.e();}
}
