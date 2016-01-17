package gus06.entity.gus.file.editor.ext.gus;

import java.awt.BorderLayout;
import java.io.File;
import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class EntityImpl implements Entity, ActionListener, I, P, R, E, Runnable {

	public String creationDate() {return "20151101";}

	
	private Service txtEditor;
	private Service console;
	private Service initKey;
	
	private JSplitPane split;
	private JTextComponent comp;
	private JButton button;
	
	private File file;
	private Thread t;
	
	

	public EntityImpl() throws Exception
	{
		txtEditor = Outside.service(this,"*gus.file.editor.ext.txt");
		console = Outside.service(this,"*gus.file.editor.ext.gus.console");
		initKey = Outside.service(this,"gus.swing.textcomp.cust2.keystroke.init");
		
		comp = (JTextComponent) txtEditor.r("comp");
		initKey.v("F12",new Object[]{comp,this});
		
		button = new JButton("Execute");
		button.addActionListener(this);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add((JComponent) txtEditor.i(),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		
		split = new JSplitPane();
		split.setDividerLocation(400);
		split.setLeftComponent(panel);
		split.setRightComponent((JComponent) console.i());
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	
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


	public void actionPerformed(ActionEvent e)
	{startScript();}
	
	
	public void e() throws Exception
	{startScript();}
	
	
	private void startScript()
	{
		if(t!=null && t.isAlive()) return;
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
	}
	
	
	public void run()
	{
		button.setForeground(Color.BLUE);
		button.setText("Executing...");
		
		try{console.p(input());}
		catch(Exception e)
		{Outside.err(this,"run()",e);}
		
		button.setForeground(Color.BLACK);
		button.setText("Execute");
	}
	


	private Object input()
	{
		String s = comp.getSelectedText();
		if(s!=null && !s.equals("")) return new Object[]{file,s};
		return file;
	}
}
