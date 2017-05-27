package gus06.entity.gus.file.editor.ext.groovy;

import java.awt.BorderLayout;
import java.io.File;
import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class EntityImpl implements Entity, I, P, G, R, E {

	public String creationDate() {return "20150706";}

	
	private Service txtEditor;
	private Service console;
	private Service putAction;
	
	private JSplitPane split;
	private JTextComponent comp;
	
	private File file;
	
	

	public EntityImpl() throws Exception
	{
		txtEditor = Outside.service(this,"*gus.file.editor.ext.txt");
		console = Outside.service(this,"*gus.file.editor.ext.groovy.console");
		putAction = Outside.service(this,"gus.swing.textcomp.cust.putaction.ctrl_q");
		
		comp = (JTextComponent) txtEditor.r("comp");
		putAction.p(new Object[]{comp,this});
		
		split = new JSplitPane();
		split.setDividerLocation(400);
		split.setLeftComponent((JComponent) txtEditor.i());
		split.setRightComponent((JComponent) console.i());
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("comp")) return comp;
		if(key.equals("keys")) return new String[]{"comp"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		txtEditor.p(file);
		console.p(null);
	}
	
	
	
	public void e() throws Exception
	{
		console.p(input());
	}


	private Object input()
	{
		String s = comp.getSelectedText();
		if(s!=null && !s.equals("")) return new Object[]{file,s};
		return file;
	}
}
