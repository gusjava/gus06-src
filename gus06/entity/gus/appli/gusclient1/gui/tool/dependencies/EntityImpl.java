package gus06.entity.gus.appli.gusclient1.gui.tool.dependencies;

import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, ActionListener, I, P {

	public String creationDate() {return "20150822";}
	
	public static final int HEIGHT = 200;


	private Service handlingGui;
	private Service engine;

	private JPanel panel;

	private String entityName;
	private File entityFile;
	private JTextComponent comp;
	
	private JButton button;

	
	
	public EntityImpl() throws Exception
	{
		handlingGui = Outside.service(this,"*gus.sys.progress1.handlingpanel1");
		engine = Outside.service(this,"gus.appli.gusclient1.gui.tool.dependencies.engine");
		
		button = new JButton("Search");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {perform();}
		});
		
		panel = new JPanel(new BorderLayout());
		panel.add(button,BorderLayout.NORTH);
		panel.add((JComponent) handlingGui.i(),BorderLayout.CENTER);
		
		handlingGui.addActionListener(this);
		setSize(new Dimension(0,HEIGHT));
	}
		
		
	private void setSize(Dimension d)
	{
		panel.setMaximumSize(d);
		panel.setMinimumSize(d);
		panel.setPreferredSize(d);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		entityName = (String) o[0];
		entityFile = (File) o[1];
		comp = (JTextComponent) o[2];
		
		handlingGui.e();
	}
	
	
	
	private void perform()
	{
		try
		{
			engine.v("entityName",entityName);
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
