package gus06.manager.gus.gyem.m091.p.mainframe.handler;

import java.awt.Container;
import javax.swing.JFrame;
import gus06.framework.G;
import gus06.framework.P;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements P {

	
	
	public void p(Object obj) throws Exception
	{
		JFrame frame = (JFrame) obj;
		
		Container c = (Container) ((G) module(M093_G_MAINGUI)).g();
		if(c!=null) frame.setContentPane(c);
		
		((P) module(M092_G_CUSTOMIZEFRAME)).p(frame);
	}
}