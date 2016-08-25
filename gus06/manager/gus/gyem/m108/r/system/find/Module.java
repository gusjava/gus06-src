package gus06.manager.gus.gyem.m108.r.system.find;

import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;
import java.io.PrintStream;

public class Module extends GyemSystem implements R {
	
	private PrintStream sysout0 = System.out;
	private PrintStream syserr0 = System.err;

	
	public Object r(String key) throws Exception
	{
		if(key.equals("sysprop")) return System.getProperties();
		if(key.equals("sysenv")) return System.getenv();
		if(key.equals("sysout")) return System.out;
		if(key.equals("syserr")) return System.err;
		if(key.equals("sysin")) return System.in;
		if(key.equals("sysout0")) return sysout0;
		if(key.equals("syserr0")) return syserr0;
		
		throw new Exception("Unknown key: "+key);
	}
}