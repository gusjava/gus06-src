package gus06.entity.gus.file.editor.ext.jar;

import gus06.framework.*;

import java.io.File;
import javax.swing.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntityImpl implements Entity, I, P, ActionListener, ListSelectionListener {

	public String creationDate() {return "20140804";}

	
	private Service fieldHolder;
	private Service findEntries;
	private Service listRenderer;
	private Service entryViewer;
	private Service listFilter;
	private Service linkerListField;
	private Service splitCust;
	
	private JComponent field;
	private JList list;
	private JLabel label;
	private JSplitPane split;
	
	private File file;
	


	public EntityImpl() throws Exception
	{
		fieldHolder = Outside.service(this,"*gus.data.editor.string.textfield.editor1");
		findEntries = Outside.service(this,"gus.file.jar.findentriesarray");
		listRenderer = Outside.service(this,"gus.file.editor.ext.jar.listrenderer");
		entryViewer = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer");
		listFilter = Outside.service(this,"gus.list.filter2");
		linkerListField = Outside.service(this,"gus.swing.list.textfield.linker");
		splitCust = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		
		list = new JList();
		listRenderer.p(list);
    		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		label = new JLabel(" ");
		field = (JComponent) fieldHolder.i();
				
		JPanel p_left = new JPanel(new BorderLayout());
		p_left.add(field,BorderLayout.NORTH);
		p_left.add(new JScrollPane(list),BorderLayout.CENTER);
		p_left.add(label,BorderLayout.SOUTH);
		
		split = new JSplitPane();
		splitCust.p(split);
		
		split.setLeftComponent(p_left);
		split.setRightComponent((JComponent) entryViewer.i());
		
		list.addListSelectionListener(this);
		fieldHolder.addActionListener(this);
		linkerListField.p(new Object[]{list,field});
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	public void actionPerformed(ActionEvent e)
	{refresh();}
	
	
	public void valueChanged(ListSelectionEvent e)
	{selectionChanged();}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file==null) resetGui();
		else updateGui();
	}
	
	
	
	private void refresh()
	{
		try
		{
			if(file==null) resetGui();
			else updateGui();
		}
		catch(Exception e)
		{Outside.err(this,"refresh()",e);}
	}
	
	
	
	
	private void updateGui() throws Exception
	{
		Vector v = buildKeys();
		list.setListData(v);
		label.setText("number: "+v.size());
		entryViewer.p(null);
	}
	
	private void resetGui() throws Exception
	{
		list.setListData(new Vector());
		label.setText(" ");
		entryViewer.p(null);
	}
	
	
	
	private Vector buildKeys() throws Exception
	{
		String rule = (String) fieldHolder.g();
		List entries = (List) findEntries.t(file);
		List entries_ = (List) listFilter.t(new Object[]{entries,rule});
		
		Vector keys = new Vector();
		keys.addAll(entries_);
		return keys;
	}
	
	
	
	
	
	private void selectionChanged()
	{
		try
		{
			String entry = (String) list.getSelectedValue();
			if(file==null || entry==null) entryViewer.p(null);
			else entryViewer.p(new Object[]{file,entry});
		}
		catch(Exception e)
		{Outside.err(this,"selectionChanged()",e);}
	}
}
