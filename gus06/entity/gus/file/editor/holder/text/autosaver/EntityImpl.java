package gus06.entity.gus.file.editor.holder.text.autosaver;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.text.JTextComponent;
import java.io.PrintStream;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EntityImpl extends S1 implements Entity, F, P, V, ActionListener {

	public String creationDate() {return "20141215";}



	private Service readFile;
	private Service writeFile;
	private Service textChanged;
	private Service fileChanged;
	
	private JTextComponent comp;
	private File file;
	
	private S textChangeWatcher;
	private S fileChangeWatcher;
	
	private boolean fileJustChanged = false;
	private boolean textJustChanged = false;



	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.autodetect");
		writeFile = Outside.service(this,"gus.file.write.string.autodetect");
		textChanged = Outside.service(this,"gus.swing.textcomp.textchanged.delayed");
		fileChanged = Outside.service(this,"gus.file.watcher.filechanged.delayed");
	}
	
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
		
		
		
	public synchronized boolean f(Object obj) throws Exception
	{
		if(comp==null) throw new Exception("Comp not initialized yet");
		
		file = (File) obj;
		comp.setEditable(file!=null);
		
		if(fileChangeWatcher!=null) fileChangeWatcher.removeActionListener(this);
		fileChangeWatcher = null;
		
		if(file!=null)
		{
			fileChangeWatcher = (S) fileChanged.t(file);
			fileChangeWatcher.addActionListener(this);
		}
		
		String text = readFile();
		if(comp.getText().equals(text)) return false;
		
		textJustChanged = true;
		comp.setText(text);
		
		comp.setCaretPosition(0);
		return true;
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("comp"))
		{initComp((JTextComponent) obj);return;}
		throw new Exception("Unknown key: "+key);
	}
	
	
	private void initComp(JTextComponent comp) throws Exception
	{
		if(this.comp!=null) throw new Exception("Comp already initialized");
		this.comp = comp;
		
		textChangeWatcher = (S) textChanged.t(comp);
		textChangeWatcher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(textJustChanged) {textJustChanged = false;return;}
				writeFile();
			}
		});
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(fileJustChanged) {fileJustChanged = false;return;}
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){reload();}
		});
		
//		int r = JOptionPane.showConfirmDialog(null,
//				"This file has been modified by another program.\nDo you want to reload it ?",
//				"File reload",
//				JOptionPane.YES_NO_OPTION);
//			
//		if(r == JOptionPane.YES_OPTION)
//		{
//			SwingUtilities.invokeLater(new Runnable(){
//				public void run(){reload();}
//			});
//		}
//		else
//		{
//			SwingUtilities.invokeLater(new Runnable(){
//				public void run(){writeFile();}
//			});
//		}
	}
	
	
	
	
	
	private synchronized void reload()
	{
		try
		{
			String text = readFile();
			if(comp.getText().equals(text)) return;
		
			textJustChanged = true;
			comp.setText(text);
			comp.setCaretPosition(0);
		}
		catch(Exception e)
		{Outside.err(this,"reload()",e);}
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
			fileJustChanged = true;
			writeFile.p(new Object[]{file,comp.getText()});
		}
		catch(Exception e)
		{Outside.err(this,"writeFile()",e);}
	}
}
