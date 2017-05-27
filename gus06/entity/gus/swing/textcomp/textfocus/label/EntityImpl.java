package gus06.entity.gus.swing.textcomp.textfocus.label;

import gus06.framework.*;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.Icon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151108";}


	private Service manager;
	private Icon icon;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.swing.textcomp.textfocus.manager");
		icon = (Icon) Outside.resource(this,"icon#TEXT_focus");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		G holder = (G) manager.t(obj);
		return new JLabel1(holder);
	}
	
	
	private class JLabel1 extends JLabel implements ActionListener
	{
		private G holder;
		
		public JLabel1(G holder)
		{
			super(" ");
			this.holder = holder;
			((S) holder).addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		{updateGui();}
		
		private void updateGui()
		{
			int number = number(holder);
			setIcon(number>=0?icon:null);
			setText(number>=1?""+number:"");
		}
	}
	
	private int number(G g)
	{
		try
		{
			List queue = (List) g.g();
			if(queue==null) return -1;
			return queue.size();
		}
		catch(Exception e)
		{Outside.err(this,"number(G)",e);}
		return -1;
	}
}
