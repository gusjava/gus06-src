package gus06.manager.gus.gyem.m093.g.maingui;

import java.awt.Container;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	
	private Container c;
	
	public Object g() throws Exception
	{
		if(c==null) init();
		return c;
	}
	
	
	
	private void init() throws Exception
	{
		try
		{
			c = (Container) ((G) module(M094_G_MAINGUI_BUILDER1)).g();
			if(c==null) c = (Container) ((G) module(M096_G_MAINGUI_DEFAULTGUI)).g();
		}
		catch(Exception ex)
		{
			c = (Container) ((T) module(M095_G_MAINGUI_BUILDER2)).t(ex);
		}
	}
}