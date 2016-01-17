package gus06.entity.gus.command.restart;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140705";}

	
	
	public void e() throws Exception
	{
		String command = (String) Outside.resource(this,"property#exec.restart");
		if(command==null) throw new Exception("Undefined property: exec.restart");
		
		Runtime.getRuntime().exec(command);
		System.exit(0);
	}
}
