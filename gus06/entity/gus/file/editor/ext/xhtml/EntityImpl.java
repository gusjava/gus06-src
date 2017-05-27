package gus06.entity.gus.file.editor.ext.xhtml;

import java.awt.BorderLayout;
import java.io.File;
import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import javax.swing.undo.UndoManager;
import java.util.Map;
import java.awt.Color;


public class EntityImpl implements Entity, I, P, G, R {

	public String creationDate() {return "20170130";}
	
	public static final String KEYSTOKE_INDENT = "ctrl i";
	public static final String KEYSTOKE_MINIMIZE = "ctrl shift i";

	
	private Service custComp;
	private Service buildComp;
	private Service buildScroll;
	private Service buildHighSup;
	private Service buildHighCount;
	private Service buildHighScroll;
	private Service buildFocusLabel;
	private Service buildCaretLabel;
	private Service buildQuickLabel;
	private Service buildUndoManager;
	private Service autoSaver;
	private Service toolbarBuilder;
	
	private Service buildActionIndent;
	private Service buildActionMinimize;
	private Service buildActionRemoveTag;
	private Service putAction;
	
	private JPanel panel;
	private JTextComponent comp;
	
	private JScrollPane scroll;
	private JComponent countComp;
	private JComponent focusComp;
	private JComponent quickComp;
	private JComponent caretComp;
	
	private Action actionIndent;
	private Action actionMinimize;
	private Action actionRemoveTag;
	
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
		buildCaretLabel = Outside.service(this,"gus.swing.textcomp.buildlabel.caretposition");
		buildQuickLabel = Outside.service(this,"gus.sys.quickreplace.holder.find.label");
		buildUndoManager = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_zy.undoredo");
		autoSaver = Outside.service(this,"*gus.file.editor.holder.text.autosaver");
		toolbarBuilder = Outside.service(this,"gus.swing.toolbar.toolbar1");
		
		buildActionIndent = Outside.service(this,"gus.file.editor.ext.xhtml.action.indent");
		buildActionMinimize = Outside.service(this,"gus.file.editor.ext.xhtml.action.minimize");
		buildActionRemoveTag = Outside.service(this,"gus.file.editor.ext.xhtml.action.remove1");
		putAction = Outside.service(this,"gus.swing.textcomp.cust.putaction");
		
		comp = (JTextComponent) buildComp.i();
		undo = (UndoManager) buildUndoManager.t(comp);
		
		S1 highSup = (S1) buildHighSup.t(comp);
		
		scroll = (JScrollPane) buildScroll.t(comp);
		countComp = (JComponent) buildHighCount.t(comp);
		focusComp = (JComponent) buildFocusLabel.t(comp);
		quickComp = (JComponent) buildQuickLabel.t(comp);
		caretComp = (JComponent) buildCaretLabel.t(comp);
		
		actionIndent = (Action) buildActionIndent.t(comp);
		actionMinimize = (Action) buildActionMinimize.t(comp);
		actionRemoveTag = (Action) buildActionRemoveTag.t(comp);
		
		custComp.p(comp);
		
		putAction.p(new Object[]{comp,actionIndent,KEYSTOKE_INDENT});
		putAction.p(new Object[]{comp,actionMinimize,KEYSTOKE_MINIMIZE});
		
		Object highScroll = buildHighScroll.t(scroll);
		highSup.addActionListener((ActionListener) countComp);
		highSup.addActionListener((ActionListener) highScroll);
		
		comp.setBackground(new Color(219,235,255));
		
		panel = new JPanel(new BorderLayout());
		panel.add(scroll,BorderLayout.CENTER);
		panel.add(bottomBar(),BorderLayout.SOUTH);
		
		autoSaver.v("comp",comp);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
	private JComponent bottomBar() throws Exception
	{
		JToolBar bar = (JToolBar) toolbarBuilder.i();
		
		bar.add(actionIndent);
		bar.add(actionMinimize);
		bar.add(actionRemoveTag);
		bar.addSeparator();
		
		bar.add(caretComp);
		bar.addSeparator();
		
		bar.add(countComp);
		bar.addSeparator();
		
		bar.add(focusComp);
		bar.addSeparator();
		
		return wc(bar,null);
	}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("comp")) return comp;
		if(key.equals("file")) return file;
		if(key.equals("keys")) return new String[]{"comp","file"};
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		((Map) ((R)comp).r("data")).put("file",file);
		
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
