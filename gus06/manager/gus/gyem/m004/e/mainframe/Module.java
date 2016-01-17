package gus06.manager.gus.gyem.m004.e.mainframe;

import gus06.framework.E;
import gus06.framework.G;
import gus06.framework.P;
import gus06.manager.gus.gyem.GyemSystem;
import javax.swing.JFrame;


public class Module extends GyemSystem implements E {

	
	public void e() throws Exception
	{
		JFrame frame = (JFrame) ((G) module(M090_G_MAINFRAME_BUILDER)).g();
		if(frame!=null) ((P) module(M091_P_MAINFRAME_HANDLER)).p(frame);
	}
}