package gus06.entity.gus.awt.fullscreen.replacecomp;

import gus06.framework.*;


import javax.swing.JComponent;
import javax.swing.JLayeredPane;


public class LayeredPaneHolder implements E {

	private JComponent comp;
	private JLayeredPane parent;
	

	public LayeredPaneHolder(JLayeredPane parent, JComponent comp)
	{
		this.comp = comp;
		this.parent = parent;
	}

	
	public void e() throws Exception
	{
		parent.add(comp);
		parent.revalidate();
		parent.repaint();
	}

}
