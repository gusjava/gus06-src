package gus06.manager.gus.gyem.m090.g.mainframe.builder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import gus06.framework.E;
import gus06.framework.F;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private JFrame frame;

	public Object g() throws Exception
	{
		if(((F) module(M013_F_PROP_BOOL_DF)).f(PROP_APPGUIDISABLED)) return null;
			
		if(frame==null) init();
		return frame;
	}

	
	
	private void init()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){askExit();}
		});
	}
	
	
	
	
	private void askExit()
	{
		try{((E) module(M097_E_EXIT_ASK)).e();}
		catch (Exception e) {System.exit(1);}
	}
}