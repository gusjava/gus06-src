package gus06.entity.gus.awt.fullscreen.replacecomp;

import gus06.framework.*;


import javax.swing.JComponent;
import javax.swing.JViewport;


public class ViewportHolder implements E {

	private JComponent comp;
	private JViewport parent;
	

	public ViewportHolder(JViewport parent, JComponent comp)
	{
		this.comp = comp;
		this.parent = parent;
	}

	
	public void e() throws Exception
	{parent.setView(comp);}

}
