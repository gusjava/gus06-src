/*
 * Created on 5 oct. 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gus06.entity.gus.awt.fullscreen.replacecomp;

import java.awt.BorderLayout;

import gus06.framework.*;


import javax.swing.JComponent;
import javax.swing.JPanel;



public class PanelBorderLayoutHolder implements E {

	private JComponent comp;
	private JPanel parent;
	private Object constraints;
	

	public PanelBorderLayoutHolder(JPanel parent, JComponent comp)
	{
		super();
		this.comp = comp;
		this.parent = parent;
		
		BorderLayout layout = (BorderLayout) parent.getLayout();
		constraints = layout.getConstraints(comp);
	}

	
	public void e() throws Exception
	{
		parent.add(comp,constraints);
	}

}
