package gus06.entity.gus.awt.fullscreen.replacecomp;

import java.awt.Component;
import javax.swing.JSplitPane;


public class Holder_SplitPane extends Holder {

	
	private JSplitPane parent;
	private Component rightComp;
	private Component leftComp;
	
	

	public Holder_SplitPane(JSplitPane parent)
	{
		super(null);
		this.parent = parent;
		rightComp = parent.getRightComponent();
		leftComp = parent.getLeftComponent();
	}

	
	protected void replaceComp()
	{
		parent.setRightComponent(rightComp);
		parent.setLeftComponent(leftComp);
	}
}
