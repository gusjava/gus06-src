package gus06.manager.gus.gyem.m097.e.exit.ask;

import gus06.framework.E;
import gus06.framework.F;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements E {

	public void e() throws Exception
	{
		boolean ok = ((F) module(M098_F_EXIT_ASK)).f(null);
		if(ok) System.exit(0);
	}
}