package gus06.entity.gus.dir.explorer.simple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;


public class EntityImpl implements Entity, I, P, ActionListener {

	public String creationDate() {return "20140723";}

	private Service tree;
	private Service editor;
	private Service renderer;
	private Service actionColEx;
	private Service splitCust;
	private Service eventHandler;
	private Service treeDnd;
	
	private JSplitPane split;


	
	public EntityImpl() throws Exception
	{
		tree = Outside.service(this,"*gus.dir.explorer.simple.tree");
		editor = Outside.service(this,"*gus.file.editor.main");

		renderer = Outside.service(this,"gus.dir.explorer.treerenderer1");
		actionColEx = Outside.service(this,"gus.swing.tree.cust.action.expandcollapseall");
		splitCust = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		eventHandler = Outside.service(this,"gus.swing.tree.cust.eventhandler.file");
		treeDnd = Outside.service(this,"gus.swing.tree.cust.dnd");

		JComponent comp = (JComponent) tree.i();
		
		renderer.p(comp);
		actionColEx.p(comp);
		eventHandler.p(comp);
		treeDnd.p(comp);
		
		split = new JSplitPane();
		splitCust.p(split);
		
		split.setLeftComponent(new JScrollPane(comp));
		split.setRightComponent((JComponent) editor.i());
		
		tree.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return split;}


	public void p(Object obj) throws Exception
	{tree.p(obj);}
	

	
	public void actionPerformed(ActionEvent e)
	{fileSelected();}
	
	
	
	private void fileSelected()
	{
		try
		{
			File file = (File) tree.g();
			if(file==null || !file.isFile()) return;
			handleFile(file);
		}
		catch(Exception e)
		{Outside.err(this,"fileSelected()",e);}
	}
	
	
	private void handleFile(File file)
	{
		try{editor.p(file);}
		catch(Exception e)
		{
			String message = "Failed to edit file: "+file;
			Outside.err(this,"fileSelected()",new Exception(message,e));
		}
	}
}
