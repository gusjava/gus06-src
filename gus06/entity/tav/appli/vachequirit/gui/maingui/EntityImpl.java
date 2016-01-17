package gus06.entity.tav.appli.vachequirit.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150615";}


	private Service screen;
	private Service capture;


	private JPanel panel;
	private JButton button;


	public EntityImpl() throws Exception
	{
		screen = Outside.service(this,"*gus.swing.panel.screen.image");
		capture = Outside.service(this,"gus.awt.robot.printscreen");
		
		button = new JButton("Capturer");
		button.addActionListener(this);
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) screen.i(),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}


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