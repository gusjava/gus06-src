package gus06.entity.gus.java.introspection.gui.gui1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntityImpl implements Entity, I, ActionListener {

	public String creationDate() {return "20140819";}


	private Service selector;
	private Service viewer;
	private Service loader;
	
	private JSplitPane split;
	
	public EntityImpl() throws Exception
	{
		selector = Outside.service(this,"*gus.java.introspection.gui.selector");
		viewer = Outside.service(this,"*gus.data.viewer.class1");
		loader = Outside.service(this,"gus.java.classloader.loader1");
		
		split = new JSplitPane();
		split.setLeftComponent((JComponent) selector.i());
		split.setRightComponent((JComponent) viewer.i());

		selector.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	public void actionPerformed(ActionEvent e)
	{classSelected();}
	
	
	
	private void classSelected()
	{
		try
		{
			String name = (String) selector.g();
			Class c = (Class) loader.t(name);
			viewer.p(c);
		}
		catch(Exception e)
		{Outside.err(this,"classSelected()",e);}
	}
}
