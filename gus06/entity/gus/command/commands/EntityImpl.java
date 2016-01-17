package gus06.entity.gus.command.commands;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140721";}

	private Service execute;

	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.command.execute");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String line = (String) obj;
		String[] nn = line.split(";");
		for(String n:nn) execute.p(n);
	}
}
