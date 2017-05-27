package gus06.entity.gus.env.windows.perform.taskkill;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170410";}
	
		

	
	public void p(Object obj) throws Exception
	{
		String pid = (String) obj;
		Runtime.getRuntime().exec("taskkill /F /PID "+pid);
	}
}
