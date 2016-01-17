package gus06.entity.gus.swing.textcomp.textfocus.label;

import gus06.framework.*;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
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
		return new JPanel1(holder);
	}
	
	
	private class JPanel1 extends JPanel implements ActionListener
	{
		private G holder;
		
		public JPanel1(G holder)
		{
			super(new GridLayout(1,0));
			this.holder = holder;
			((S) holder).addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		{updateGui();}
		
		private void updateGui()
		{
			int number = number(holder);
			removeAll();
			for(int i=0;i<number;i++)
			add(new JLabel(icon));
		}
	}
	
	
	private int number(G g)
	{
		try
		{
			List queue = (List) g.g();
			return queue.size();
		}
		catch(Exception e)
		{Outside.err(this,"number(G)",e);}
		return 0;
	}
}
