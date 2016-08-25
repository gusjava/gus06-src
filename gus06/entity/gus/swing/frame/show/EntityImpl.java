package gus06.entity.gus.swing.frame.show;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class EntityImpl implements Entity, T, V, P {

	public String creationDate() {return "20151001";}


	private Service findComp;
	private Service custDisplay;

	public EntityImpl() throws Exception
	{
		findComp = Outside.service(this,"gus.find.jcomponent");
		custDisplay = Outside.service(this,"gus.swing.frame.cust2.display");
	}
	
	
	
	public void p(Object obj) throws Exception
	{frame(obj);}
	
	public void v(String key, Object obj) throws Exception
	{custDisplay.v(key,frame(obj));}
	
	public Object t(Object obj) throws Exception
	{return frame(obj);}
	
	
	
	
	private JFrame frame(Object obj) throws Exception
	{
		JComponent comp = (JComponent) findComp.t(obj);
		
		JFrame frame = new JFrame();
		frame.setContentPane(comp);
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		return frame;
	}
}
