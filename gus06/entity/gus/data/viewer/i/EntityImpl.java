package gus06.entity.gus.data.viewer.i;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, I, P, G, ActionListener {

	public String creationDate() {return "20140731";}

	private Service viewer;
	
	private JPanel panel;
	private JButton button;
	
	private I data;
	
	
	public EntityImpl() throws Exception
	{
		viewer = Outside.service(this,"*gus.data.viewer.object");
		
		button = new JButton("Call i()");
		button.addActionListener(this);
		
		panel = new JPanel(new BorderLayout());
		panel.add(button,BorderLayout.NORTH);
		panel.add((JComponent) viewer.i(),BorderLayout.CENTER);
	}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public void p(Object obj) throws Exception
	{
		data = (I) obj;
		button.setEnabled(data!=null);
		viewer.p(null);
	}
	
	public void actionPerformed(ActionEvent e)
	{showData();}
	
	
	private void showData()
	{
		try{viewer.p(data.i());}
		catch(Exception e){Outside.err(this,"showData()",e);}
	}
}
