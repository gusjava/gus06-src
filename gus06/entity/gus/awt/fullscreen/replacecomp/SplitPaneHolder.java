package gus06.entity.gus.awt.fullscreen.replacecomp;

import java.awt.Component;

import gus06.framework.*;


import javax.swing.JSplitPane;


public class SplitPaneHolder implements E {

	
	private JSplitPane parent;
	private Component rightComp;
	private Component leftComp;
	
	

	public SplitPaneHolder(JSplitPane parent)
	{
		this.parent = parent;
		rightComp = parent.getRightComponent();
		leftComp = parent.getLeftComponent();
	}

	
	public void e() throws Exception
	{
		parent.setRightComponent(rightComp);
		parent.setLeftComponent(leftComp);
	}

}
