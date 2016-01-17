package gus06.entity.gus.swing.textcomp.cust.autoedit.offset;

import gus06.framework.*;
import javax.swing.text.*;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140727";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.swing.textcomp.cust.autoedit.offset.perform");}



	public void p(Object obj) throws Exception
	{new Holder((JTextComponent) obj);}




	private class Holder implements KeyListener
	{
		private JTextComponent comp;
		public Holder(JTextComponent comp)
		{
			this.comp = comp;
			comp.addKeyListener(this);
		}

		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e)
		{if(e.getKeyCode()==KeyEvent.VK_ENTER) autoEdit();}

		private void autoEdit()
		{
			SwingUtilities.invokeLater(new Runnable()
				{public void run() {perform(comp);}
			});
		}		
	}



	private void perform(JTextComponent comp)
	{
		try {perform.p(comp);}
		catch(Exception e)
		{Outside.err(this,"perform(JTextComponent)",e);}
	}
}
