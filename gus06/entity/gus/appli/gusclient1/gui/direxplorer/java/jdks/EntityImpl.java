package gus06.entity.gus.appli.gusclient1.gui.direxplorer.java.jdks;

import gus06.framework.*;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class EntityImpl implements Entity, I, ListSelectionListener {

	public String creationDate() {return "20140830";}

	private Service listRenderer;
	private Service explorer;
	private Service findJdks;
	private Service splitCust;
	
	private File[] jdks;
	private JSplitPane split;
	private JList list;
	
	
	public EntityImpl() throws Exception
	{
		listRenderer = Outside.service(this,"gus.swing.list.cust.renderer.file");
		explorer = Outside.service(this,"*gus.dir.explorer.simple");
		findJdks = Outside.service(this,"gus.java.jdk.dirs");
		splitCust = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		
		jdks = (File[]) findJdks.g();
		list = new JList(jdks);
		listRenderer.p(list);
		
		split = new JSplitPane();
		splitCust.p(split);
		
		split.setLeftComponent(new JScrollPane(list));
		split.setRightComponent((JComponent) explorer.i());
		
		list.addListSelectionListener(this);
	}
	
	
	
	public Object i() throws Exception
	{return split;}


	public void valueChanged(ListSelectionEvent e)
	{selectionChanged();}
	
	
	
	private void selectionChanged()
	{
		try
		{
			File dir = (File) list.getSelectedValue();
			explorer.p(dir);
		}
		catch(Exception e)
		{Outside.err(this,"selectionChanged()",e);}
	}
}
