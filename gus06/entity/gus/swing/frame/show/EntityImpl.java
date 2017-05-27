package gus06.entity.gus.swing.frame.show;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.Scrollable;
import javax.swing.JScrollPane;

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
	{
		JFrame frame = toFrame(obj);
		frame.setVisible(true);
	}
	
	public void v(String key, Object obj) throws Exception
	{
		JFrame frame = toFrame(obj);
		custDisplay.v(key,frame);
		frame.setVisible(true);
	}
	
	public Object t(Object obj) throws Exception
	{
		JFrame frame = toFrame(obj);
		frame.setVisible(true);
		return frame;
	}
	
	
	
	
	private JFrame toFrame(Object obj) throws Exception
	{
		if(obj instanceof JFrame) return (JFrame) obj;
		if(obj instanceof Object[]) return toFrame2((Object[]) obj);
		
		JComponent comp = findComp(obj);
		
		JFrame frame = new JFrame();
		frame.setContentPane(comp);
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);
		
		return frame;
	}
	
	
	
	private JFrame toFrame2(Object[] o) throws Exception
	{
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		JComponent comp = findComp(o[0]);
		Dimension dim = (Dimension) o[1];
		String title = (String) o[2];
		
		JFrame frame = new JFrame();
		frame.setContentPane(comp);
		frame.setSize(dim);
		frame.setLocationRelativeTo(null);
		
		custDisplay.v(title,frame);
		return frame;
	}
	
	
	private JComponent findComp(Object obj) throws Exception
	{
		JComponent comp = (JComponent) findComp.t(obj);
		if(comp instanceof Scrollable) comp = new JScrollPane(comp);
		return comp;
	}
}
