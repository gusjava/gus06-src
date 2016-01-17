package gus06.entity.gus.appli.entityaccess.gui.upload;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150227";}


	private Service handlingGui;
	private Service engine;
	
	private JPanel panel;
	private JButton button;
	

	public EntityImpl() throws Exception
	{
		handlingGui = Outside.service(this,"*gus.sys.progress1.handlingpanel1");
		engine = Outside.service(this,"gus.appli.entityaccess.engine.upload");
		
		button = new JButton("Upload all");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {perform();}
		});
		
		panel = new JPanel(new BorderLayout());
		panel.add(button,BorderLayout.NORTH);
		panel.add((JComponent) handlingGui.i(),BorderLayout.CENTER);
		
		handlingGui.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return panel;}


	
	
	
	private void perform()
	{
		try
		{
			handlingGui.p(engine);
			button.setEnabled(false);
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{reset();}
	
	private void reset()
	{button.setEnabled(true);}
}
