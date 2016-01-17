package gus06.entity.gus.swing.panel.holder.grid1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;


public class EntityImpl implements Entity, I, V {

	public String creationDate() {return "20150615";}


	private Service repaintLabel;
	private JPanel comp;
	
	
	public EntityImpl() throws Exception
	{
		repaintLabel = Outside.service(this,"gus.swing.label.cust2.display");
		
		comp = new JPanel(new GridLayout(1,0,10,10));
		comp.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}
	
	
	public Object i() throws Exception
	{return comp;}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		JComponent c = (JComponent) obj;
		JLabel l = buildLabel(key);
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(l,BorderLayout.NORTH);
		p.add(c,BorderLayout.CENTER);
		
		comp.add(p);
	}
	
	
	
	private JLabel buildLabel(String display) throws Exception
	{
		JLabel l = new JLabel(" ");
		repaintLabel.v(display,l);
		return l;
	}
}
