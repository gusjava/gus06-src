package gus06.entity.gus.awt.fullscreen.replacecomp;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class Holder_PanelGridLayout extends Holder {

	private JPanel parent;
	

	public Holder_PanelGridLayout(JPanel parent, JComponent comp)
	{
		super(comp);
		this.parent = parent;
	}

	
	protected void replaceComp()
	{parent.add(comp);}
}
