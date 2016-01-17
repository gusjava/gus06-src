package gus06.entity.gus.swing.panel.formpanel;

import gus06.framework.*;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class EntityImpl implements Entity, I, V, E {

	public String creationDate() {return "20140801";}


	private FormJPanel panel;

	public EntityImpl() throws Exception
	{panel = new FormJPanel();}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public void v(String key, Object obj) throws Exception
	{panel.addLabel(key,(JComponent) obj);}
	
	
	public void e() throws Exception
	{panel.removeLabels();}	
	
	
	
	public class FormJPanel extends JPanel
	{
		public FormJPanel()
		{
			super();
			setBorder(new EmptyBorder(10, 10, 10, 10));
			setLayout(new FormLayout(20, 5)); 
		}
    
		public void addLabel(String name, JComponent comp)
		{
			add(label(name));
			add(comp);
			revalidate();
		}
    
    
		public void insertLabelAt(int index ,String name, JComponent comp)
		{
			add(comp,index*2);
			add(label(name),index*2);
			revalidate();
		}
    
    
		public void removeLabelAt(int index)
		{
			remove(index*2);
			remove(index*2);
			revalidate();
		}
		
		
		public void removeLabels()
		{
			removeAll();
			revalidate();
		}
		
		
		private JLabel label(String name)
		{
			JLabel l = new JLabel(name);
			l.setFont(l.getFont().deriveFont(Font.BOLD));
			return l;
		}
	}
}
