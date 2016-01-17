package gus06.entity.gus.command.compile;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, E, P {

	public String creationDate() {return "20140722";}

	private Service compiler;

	public EntityImpl() throws Exception
	{compiler = Outside.service(this,"gus.java.compiler1");}
	
	
	public void e() throws Exception
	{compiler.e();}


	public void p(Object obj) throws Exception
	{compiler.v((String) obj,null);}
}
