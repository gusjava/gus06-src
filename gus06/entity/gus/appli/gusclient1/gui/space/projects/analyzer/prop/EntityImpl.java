package gus06.entity.gus.appli.gusclient1.gui.space.projects.analyzer.prop;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150312";}


	private Service loadConfig;
	private Service viewer;
	private Service manager;

	private JPanel panel;
	private JButton button;
	
	

	public EntityImpl() throws Exception
	{
		loadConfig = Outside.service(this,"gus.appli.gusclient1.project.config.load2.prop");
		viewer = Outside.service(this,"*gus.data.viewer.map.stringmap");
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		
		button = new JButton("Analyze");
		button.addActionListener(this);
		
		panel = new JPanel(new BorderLayout());
		panel.add(button,BorderLayout.SOUTH);
		panel.add((JComponent) viewer.i(),BorderLayout.CENTER);
		
		manager.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){reset();}
		});
	}
	
	
	public Object i() throws Exception
	{return panel;}


	public void actionPerformed(ActionEvent e)
	{perform();}
	
	
	private void perform()
	{
		try
		{
			Map config = (Map) loadConfig.g();
			viewer.p(config);
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
	
	
	private void reset()
	{
		try{viewer.p(null);}
		catch(Exception e)
		{Outside.err(this,"reset()",e);}
	}
}
