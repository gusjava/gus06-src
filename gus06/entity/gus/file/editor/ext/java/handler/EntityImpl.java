package gus06.entity.gus.file.editor.ext.java.handler;

import gus06.framework.*;

import java.io.File;
import java.io.PrintStream;
import javax.swing.text.JTextComponent;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Event;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140728";}

	public static final String KEYSTROKE_COMPILE = "ctrl m";

	private Service readFile;
	private Service writeFile;
	private Service textChanged;
	private Service fileChanged;
	private Service putAction;
	private Service compileFile;
	private Service buildAction;
	private Service boolprop;


	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		writeFile = Outside.service(this,"gus.file.write.string");
		textChanged = Outside.service(this,"gus.swing.textcomp.textchanged.delayed");
		fileChanged = Outside.service(this,"gus.file.watcher.filechanged.delayed");
		putAction = Outside.service(this,"gus.swing.textcomp.cust.action.put");
		compileFile = Outside.service(this,"gus.java.compiler.file");
		buildAction = Outside.service(this,"gus.convert.executetoaction2");
		boolprop = Outside.service(this,"propbool_df");
	}
	
	
	public Object t(Object obj) throws Exception
	{return new Holder((JTextComponent) obj);}
	
	
	
	
	private class Holder implements P, ActionListener
	{
		private JTextComponent comp;
		private File file;
		private Action action;
		
		private boolean fileJustChanged = false;
		private boolean textJustChanged = false;
		
		private S textChangeWatcher;
		private S fileChangeWatcher;
		
		
		public Holder(JTextComponent comp) throws Exception
		{
			this.comp = comp;
			
			action = (Action) buildAction.t(new E(){
				public void e() throws Exception {compile();}
			});
			putAction.p(new Object[]{comp,action,KEYSTROKE_COMPILE});
			
			textChangeWatcher = (S) textChanged.t(comp);
			textChangeWatcher.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{textChanged();}
			});
		}
		
		
		
		public synchronized void p(Object obj) throws Exception
		{
			file = (File) obj;
			comp.setEditable(file!=null);
		
			if(fileChangeWatcher!=null) fileChangeWatcher.removeActionListener(this);
			fileChangeWatcher = null;
		
			if(file!=null)
			{
				fileChangeWatcher = (S) fileChanged.t(file);
				fileChangeWatcher.addActionListener(this);
			}
		
			String text = readFile(file);
			if(comp.getText().equals(text)) return;
		
			textJustChanged = true;
			comp.setText(text);
			comp.setCaretPosition(0);
		}
	
		public void actionPerformed(ActionEvent e)
		{fileChanged();}
		
		
		
		
		private synchronized void textChanged()
		{
			if(textJustChanged) {textJustChanged = false;return;}
			write();
		}
		
		
		private synchronized void fileChanged()
		{
			if(fileJustChanged) {fileJustChanged = false;return;}
			
			SwingUtilities.invokeLater(new Runnable(){
					public void run(){reload();}
			});
			
//			int r = JOptionPane.showConfirmDialog(null,
//				"This file has been modified by another program.\nDo you want to reload it ?",
//				"File reload",
//				JOptionPane.YES_NO_OPTION);
//			
//			if(r == JOptionPane.YES_OPTION)
//			{
//				SwingUtilities.invokeLater(new Runnable(){
//					public void run(){reload();}
//				});
//			}
//			else
//			{
//				SwingUtilities.invokeLater(new Runnable(){
//					public void run(){write();}
//				});
//			}
		}
		
		
		
		
		private void reload()
		{
			String text = readFile1(file);
			if(text==null || text.equals("")) return;
			if(comp.getText().equals(text)) return;
		
			textJustChanged = true;
			comp.setText(text);
			comp.setCaretPosition(0);
		}
		
		
		
		private void write()
		{
			if(file==null) return;
			if(!file.canWrite()) return;
			
			String text = comp.getText();
			if(text.equals("")) return;
			
			fileJustChanged = true;
			writeFile(file,text);
		}
		
		private void compile()
		{compileFile(file);}
	}
	
	
	
	
	
	private String readFile1(File file)
	{
		try{return readFile(file);}
		catch(Exception e)
		{Outside.err(this,"readFile1(File)",e);}
		return "";
	}
	
	
	private String readFile(File file) throws Exception
	{
		if(file==null || !file.exists()) return "";
		return (String) readFile.t(file);
	}
	
	
	private void writeFile(File file, String text)
	{
		try
		{
			String s = text.replace("\r","");
			writeFile.p(new Object[]{file,s});
		}
		catch(Exception e)
		{Outside.err(this,"writeFile(File,String)",e);}
	}
	
	
	private void compileFile(File file)
	{
		try
		{
			if(file==null || !file.exists()) return;
			compileFile.p(file);
		}
		catch(Exception e)
		{Outside.err(this,"compileFile(File)",e);}
	}
}
