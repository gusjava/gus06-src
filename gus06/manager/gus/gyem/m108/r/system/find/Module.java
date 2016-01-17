package gus06.manager.gus.gyem.m108.r.system.find;

import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements R {

	
	public Object r(String key) throws Exception
	{
		if(key.equals("sysprop")) return System.getProperties();
		if(key.equals("sysenv")) return System.getenv();
		if(key.equals("sysout")) return System.out;
		if(key.equals("syserr")) return System.err;
		if(key.equals("sysin")) return System.in;
		
		throw new Exception("Unknown key: "+key);
	}
}