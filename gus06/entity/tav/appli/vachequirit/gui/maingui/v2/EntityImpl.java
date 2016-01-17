package gus06.entity.tav.appli.vachequirit.gui.maingui.v2;

import gus06.framework.*;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150616";}


	private Service screen;
	private Service capture;
	private Service timer;


	public EntityImpl() throws Exception
	{
		screen = Outside.service(this,"*gus.swing.panel.screen.image");
		capture = Outside.service(this,"gus.awt.robot.printscreen");
		timer = Outside.service(this,"gus.time.timer.ms100");
		
		timer.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return screen.i();}


	public void actionPerformed(ActionEvent e)
	{perform();}
	
	
	
	private void perform()
	{
		try
		{
			Object img = capture.g();
			screen.p(img);
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
}