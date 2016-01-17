package gus06.entity.gus.app.pid;

import java.lang.management.ManagementFactory;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140703";}
	
	
	String pid;
	
	public Object g() throws Exception
	{
		if(pid==null) pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
		return pid;
	}
}
