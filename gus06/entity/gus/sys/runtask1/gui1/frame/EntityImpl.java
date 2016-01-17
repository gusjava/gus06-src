package gus06.entity.gus.sys.runtask1.gui1.frame;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.JComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150609";}
	
	public static final String DISPLAY = "TASK#Tasks";


	private Service gui;
	private Service custFrame;
	private Service persistFrame;
	
	private JFrame frame;


	public EntityImpl() throws Exception
	{
		gui = Outside.service(this,"*gus.sys.runtask1.gui1");
		custFrame = Outside.service(this,"gus.swing.frame.cust2.display");
		persistFrame = Outside.service(this,"gus.swing.frame.persister.bounds");
		
		frame = new JFrame();
		frame.setContentPane((JComponent) gui.i());
		frame.setSize(600,200);
		frame.setLocationRelativeTo(null);
		
		custFrame.v(DISPLAY,frame);
		persistFrame.v(getClass().getName()+"_frame",frame);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		String s = (String) obj;
		
		if(s.equals("switch")) switch1();
		else if(s.equals("show")) show();
		else if(s.equals("hide")) hide();
	}
	
	
	
	
	private void show()
	{frame.setVisible(true);}
	
	private void hide()
	{frame.setVisible(false);}
	
	private void switch1()
	{frame.setVisible(!frame.isVisible());}
}
