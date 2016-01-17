package gus06.entity.gus.file.editor.holder.text.autosaver;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.text.JTextComponent;
import java.io.PrintStream;

public class EntityImpl extends S1 implements Entity, F, P, V, ActionListener {

	public String creationDate() {return "20141215";}



	private Service readFile;
	private Service writeFile;
	private Service textChanged;
	
	private P changeWatcher;
	private JTextComponent comp;
	private File file;
	



	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.autodetect");
		writeFile = Outside.service(this,"gus.file.write.string.autodetect");
		textChanged = Outside.service(this,"gus.swing.textcomp.textchanged.delayed");
	}
	
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
		
		
		
	public boolean f(Object obj) throws Exception
	{
		if(comp==null) throw new Exception("Comp not initialized yet");
		
		file = (File) obj;
		comp.setEditable(file!=null);
		
		String text = readFile();
		if(comp.getText().equals(text)) return false;
		
		changeWatcher.p("disactivate");
		comp.setText(text);
		changeWatcher.p("activate");
		
		comp.setCaretPosition(0);
		return true;
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("comp")) {initComp((JTextComponent) obj);return;}
		throw new Exception("Unknown key: "+key);
	}
	
	
	private void initComp(JTextComponent comp) throws Exception
	{
		if(this.comp!=null)
			throw new Exception("Comp already initialized");
		this.comp = comp;
		
		changeWatcher = (P) textChanged.t(comp);
		((S) changeWatcher).addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		writeFile();
	}
	
	
	
	
	private String readFile() throws Exception
	{
		if(file==null || !file.exists()) return "";
		return (String) readFile.t(file);
	}

	
	
	private void writeFile()
	{
		try
		{
			writeFile.p(new Object[]{file,comp.getText()});
		}
		catch(Exception e)
		{Outside.err(this,"writeFile()",e);}
	}
}
