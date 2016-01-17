package gus06.entity.gus.file.editor.main;

import java.awt.BorderLayout;
import java.io.File;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140723";}

	

	private Service editorBuilder;
	private Service shiftPanel;
	private Service fileLabel;
	
	private JPanel panel;
	private Object editor;
	

	public EntityImpl() throws Exception
	{
		editorBuilder = Outside.service(this,"*gus.file.editor.main.builder.async");
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		fileLabel = Outside.service(this,"*gus.swing.label.hold.file");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) fileLabel.i(),BorderLayout.NORTH);
		panel.add((JComponent) shiftPanel.i(),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		
		if(editor!=null) ((P)editor).p(null);
		editor = editorBuilder.t(file);
		
		fileLabel.p(file);
		shiftPanel.p(editor);
	}
}
