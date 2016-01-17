package gus06.manager.gus.gyem.m113.e.type.swing;

import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements E {
	
	public void e() throws Exception
	{
		((E) module(M004_E_MAINFRAME)).e();
		((E) module(M005_E_AFTER)).e();
		((E) module(M006_E_STARTED)).e();
	}
}