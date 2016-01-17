package gus06.entity.gus.system.out.println;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140727";}
	
	
	public void p(Object obj) throws Exception
	{System.out.println(obj);}
}