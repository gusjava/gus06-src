package gus06.entity.gus.file.editor.main;

import java.awt.BorderLayout;
import java.io.File;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I, P, R {

	public String creationDate() {return "20140723";}

	

	private Service editorBuilder;
	private Service shiftPanel;
	private Service fileLabel;
	private Service recorder;
	
	private JPanel panel;
	private Object editor;
	private File file;
	

	public EntityImpl() throws Exception
	{
		editorBuilder = Outside.service(this,"*gus.file.editor.main.builder.async");
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		fileLabel = Outside.service(this,"*gus.swing.label.hold.file");
		recorder = Outside.service(this,"gus.file.editor.main.recorder");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) fileLabel.i(),BorderLayout.NORTH);
		panel.add((JComponent) shiftPanel.i(),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		
		if(editor!=null) ((P)editor).p(null);
		editor = editorBuilder.t(file);
		
		fileLabel.p(file);
		shiftPanel.p(editor);
		
		recorder.p(new Object[]{this,file});
	}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("file")) return file;
		if(key.equals("editor")) return editor;
		
		if(key.equals("keys")) return new String[]{"file","editor"};
		throw new Exception("Unknown key: "+key);
	}
}
