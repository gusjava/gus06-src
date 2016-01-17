package gus06.entity.gus.nnn.swing.comp.focus.whendisplayed;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140724";}
	
	
	public void p(Object obj) throws Exception
	{new Holder((JComponent) obj);}


	private class Holder implements ComponentListener
	{
		private JComponent c;
		public Holder(JComponent c)
		{
			this.c = c;
			c.addComponentListener(this);
		}

		public void componentHidden(ComponentEvent e) {}
		public void componentMoved(ComponentEvent e) {}
		public void componentResized(ComponentEvent e) {}
		public void componentShown(ComponentEvent e)
		{
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {c.requestFocusInWindow();}
			});
		}
	}
}
