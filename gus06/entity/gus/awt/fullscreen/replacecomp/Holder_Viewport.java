package gus06.entity.gus.awt.fullscreen.replacecomp;


import javax.swing.JComponent;
import javax.swing.JViewport;

public class Holder_Viewport extends Holder {

	private JViewport parent;
	

	public Holder_Viewport(JViewport parent, JComponent comp)
	{
		super(comp);
		this.parent = parent;
	}

	protected void replaceComp()
	{parent.setView(comp);}
}
