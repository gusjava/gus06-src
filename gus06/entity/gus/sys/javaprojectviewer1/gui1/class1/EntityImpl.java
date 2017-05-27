package gus06.entity.gus.sys.javaprojectviewer1.gui1.class1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

public class EntityImpl implements Entity, I, P, ActionListener {

	public String creationDate() {return "20170220";}
	
	public static final int POSITION = 400;
	
	
	private Service list;
	private Service editor;
	
	private JSplitPane split;
	
	private Object data;
	
	
	
	public EntityImpl() throws Exception
	{
		list = Outside.service(this,"*gus.sys.javaprojectviewer1.gui1.class1.list");
		editor = Outside.service(this,"*gus.sys.javaprojectviewer1.gui1.editor");
		
		split = new JSplitPane();
		split.setDividerSize(3);
		split.setDividerLocation(POSITION);

		split.setLeftComponent((JComponent) list.i());
		split.setRightComponent((JComponent) editor.i());
		
		list.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		data = obj;
		list.p(data);
		editor.p(null);
	}
	
	



	public void actionPerformed(ActionEvent e)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {selectionChanged();}
		});
	}
	
	
	
	
	private void selectionChanged()
	{
		try
		{
			Object selected = list.g();
			editor.p(selected);
		}
		catch(Exception e)
		{Outside.err(this,"selectionChanged()",e);}
	}
}
