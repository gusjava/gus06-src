package gus06.entity.gus.file.editor.default0;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140723";}

	
	private Service shiftPanel;
	private Service editorTxt;
	private Service editorProp;
	
	private JPanel panel;
	private JButton buttonTxt;
	private JButton buttonProp;
	
	private File file;
	

	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		editorTxt = Outside.service(this,"*gus.file.editor.ext.txt");
		editorProp = Outside.service(this,"*gus.file.editor.ext.properties");
		
		buttonTxt = new JButton("Txt");
		buttonTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {initTxt();}
		});
		buttonProp = new JButton("Prop");
		buttonProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {initProp();}
		});
		
		JPanel p = new JPanel(new GridLayout(1,2));
		p.add(buttonTxt);
		p.add(buttonProp);
				
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) shiftPanel.i(),BorderLayout.CENTER);
		panel.add(p,BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		
		editorTxt.p(null);
		editorProp.p(null);
		shiftPanel.p(null);
	}
	
	
	
	private void initTxt()
	{
		try
		{
			editorTxt.p(file);
			shiftPanel.p(editorTxt.i());
		}
		catch(Exception e)
		{Outside.err(this,"initTxt()",e);}
	}
	
	
	private void initProp()
	{
		try
		{
			editorProp.p(file);
			shiftPanel.p(editorProp.i());
		}
		catch(Exception e)
		{Outside.err(this,"initProp()",e);}
	}
}
