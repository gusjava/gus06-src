package gus06.entity.gus.system.err.println;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140730";}
	
	
	public void p(Object obj) throws Exception
	{System.err.println(obj);}
}
