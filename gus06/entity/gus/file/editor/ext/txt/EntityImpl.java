package gus06.entity.gus.file.editor.ext.txt;

import java.awt.BorderLayout;
import java.io.File;
import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import javax.swing.undo.UndoManager;


public class EntityImpl implements Entity, I, P, R {

	public String creationDate() {return "20140831";}

	
	private Service custComp;
	private Service buildComp;
	private Service buildScroll;
	private Service buildHighSup;
	private Service buildHighCount;
	private Service buildHighScroll;
	private Service buildFocusLabel;
	private Service buildUndoManager;
	private Service autoSaver;
	
	private JPanel panel;
	private JTextComponent comp;
	private JScrollPane scroll;
	private JComponent countComp;
	private JComponent focusComp;
	
	private File file;
	private UndoManager undo;
	

	public EntityImpl() throws Exception
	{
		custComp = Outside.service(this,"gus.file.editor.ext.txt.custcomp");
		buildComp = Outside.service(this,"gus.swing.textarea.factory1");
		buildScroll = Outside.service(this,"gus.swing.textarea.buildscrollpane.linenb");
		buildHighSup = Outside.service(this,"gus.swing.textcomp.highlight.sys1.support");
		buildHighCount = Outside.service(this,"gus.swing.textcomp.highlight.sys1.countbar");
		buildHighScroll = Outside.service(this,"gus.swing.textcomp.highlight.sys1.scrollpaint");
		buildFocusLabel = Outside.service(this,"gus.swing.textcomp.textfocus.label");
		buildUndoManager = Outside.service(this,"gus.swing.textcomp.cust.action.zy.undoredo");
		autoSaver = Outside.service(this,"*gus.file.editor.holder.text.autosaver");
		
		comp = (JTextComponent) buildComp.i();
		undo = (UndoManager) buildUndoManager.t(comp);
		
		S1 highSup = (S1) buildHighSup.t(comp);
		
		scroll = (JScrollPane) buildScroll.t(comp);
		countComp = (JComponent) buildHighCount.t(comp);
		focusComp = (JComponent) buildFocusLabel.t(comp);
		
		custComp.p(comp);
		
		Object highScroll = buildHighScroll.t(scroll);
		highSup.addActionListener((ActionListener) countComp);
		highSup.addActionListener((ActionListener) highScroll);
		
		panel = new JPanel(new BorderLayout());
		panel.add(scroll,BorderLayout.CENTER);
		panel.add(wc(countComp,wc(focusComp,null)),BorderLayout.SOUTH);
		
		autoSaver.v("comp",comp);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("comp")) return comp;
		if(key.equals("keys")) return new String[]{"comp"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		boolean loaded = autoSaver.f(file);
		if(loaded) undo.discardAllEdits();
	}
	
	
	
	private JPanel wc(JComponent w, JComponent c)
	{
		if(c==null) c = new JPanel();
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(w,BorderLayout.WEST);
		p.add(c,BorderLayout.CENTER);
		return p;
	}
}
