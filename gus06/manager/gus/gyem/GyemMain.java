package gus06.manager.gus.gyem;

import gus06.framework.E;

public class GyemMain extends GyemSystem {

	public static void main(String[] args)
	{
		try
		{
			initMain(args);
			initModules();
			initManager();
			
			((E) module(M001_E_CUSTOMIZER)).e();
			((E) module(M002_E_LAUNCHER)).e();
		}
		catch(Exception e)
		{fatal_main(e);}
	}
}