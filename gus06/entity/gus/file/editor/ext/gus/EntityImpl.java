package gus06.entity.gus.file.editor.ext.gus;

import java.awt.BorderLayout;
import java.io.File;
import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class EntityImpl implements Entity, ActionListener, I, P, G, R, E, Runnable {

	public String creationDate() {return "20151101";}

	
	private Service txtEditor;
	private Service console;
	private Service putAction;
	private Service autoCompleteOP;
	private Service splitInv;
	private Service wrap;
	
	private JSplitPane split;
	private JTextComponent comp;
	private JButton button;
	
	private File file;
	private Thread t;
	
	
	

	public EntityImpl() throws Exception
	{
		txtEditor = Outside.service(this,"*gus.file.editor.ext.txt");
		console = Outside.service(this,"*gus.file.editor.ext.gus.console");
		putAction = Outside.service(this,"gus.swing.textcomp.cust.putaction");
		autoCompleteOP = Outside.service(this,"gus.swing.textcomp.cust.action.f2.gusscript.autocomplete.op");
		splitInv = Outside.service(this,"gus.swing.splitpane.inv");
		wrap = Outside.service(this,"gus.feature.wrap.p.t2e");
		
		comp = (JTextComponent) txtEditor.r("comp");
		
		autoCompleteOP.p(comp);
		
		button = new JButton("Execute");
		button.addActionListener(this);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add((JComponent) txtEditor.i(),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		
		split = new JSplitPane();
		split.setDividerLocation(400);
		split.setLeftComponent(panel);
		split.setRightComponent((JComponent) console.i());
		
		E executeInv = (E) ((T) wrap.t(splitInv)).t(split);
		E executeLapse = new E(){public void e() throws Exception {initLapse();}};
		
		putAction.p(new Object[]{comp,this,"F12"});
		putAction.p(new Object[]{comp,executeInv,"F11"});
		putAction.p(new Object[]{comp,executeLapse,"F10"});
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
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
	
	private void initLapse() throws Exception
	{
		console.v("lapse","10");
	}
	
	
	public void run()
	{
		button.setForeground(Color.BLUE);
		button.setText("Executing...");
		button.setFont(button.getFont().deriveFont(Font.BOLD));
		
		try
		{
			console.p(input());
			Thread.sleep(200);
		}
		catch(Exception e)
		{Outside.err(this,"run()",e);}
		
		button.setFont(button.getFont().deriveFont(Font.PLAIN));
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
