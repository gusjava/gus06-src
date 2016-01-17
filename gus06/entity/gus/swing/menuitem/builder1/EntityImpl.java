package gus06.entity.gus.swing.menuitem.builder1;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140726";}
	
	
	public Object t(Object obj) throws Exception
	{return new JMenuItem1((E) obj);}



	private class JMenuItem1 extends JMenuItem implements ActionListener
	{
		private E e;
		public JMenuItem1(E e)
		{
			super();
			this.e = e;
			addActionListener(this);
		}
		public void actionPerformed(ActionEvent evt)
		{execute(e);}
	}
	
	
	
	private void execute(E e)
	{
		try{e.e();}
		catch(Exception ex)
		{Outside.err(this,"execute(E)",ex);}
	}

}
