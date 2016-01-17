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


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140728";}

	public static final String KEY_AUTOCOMPILE = "dev.compile.auto";
	public static final String KEYSTROKE_COMPILE = "ctrl m";

	private Service readFile;
	private Service writeFile;
	private Service textChanged;
	private Service putAction;
	private Service compileFile;
	private Service buildAction;
	private Service boolprop;


	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		writeFile = Outside.service(this,"gus.file.write.string");
		textChanged = Outside.service(this,"gus.swing.textcomp.textchanged.delayed");
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
		
		private boolean justLoaded = false;
		
		
		public Holder(JTextComponent comp) throws Exception
		{
			this.comp = comp;
			
			action = (Action) buildAction.t(new E(){
				public void e() throws Exception {writeCompile(true);}
			});
			
			putAction.p(new Object[]{comp,action,KEYSTROKE_COMPILE});
			((S) textChanged.t(comp)).addActionListener(this);
		}
		
		
		public void p(Object obj) throws Exception
		{
			file = (File) obj;
			justLoaded = true;
		
			comp.setText(readFile(file));
			comp.setCaretPosition(0);
		}
		
	
		public void actionPerformed(ActionEvent e)
		{
			if(!justLoaded) writeCompile(isAutoCompile());
			justLoaded = false;
		}
		
		
		private void writeCompile(boolean value)
		{
			if(canEdit(file)) writeFile(file,comp);
			if(value) compileFile(file);
		}
	}
	
	
	
	
	private String readFile(File file) throws Exception
	{
		if(file==null || !file.exists()) return "";
		return (String) readFile.t(file);
	}
	
	
	
	
	
	
	private void writeFile(File file, JTextComponent comp)
	{
		try
		{
			if(file==null) return;
			String text = comp.getText();
			if(text.equals("")) return;
			
			String s = text.replace("\r","");
			writeFile.p(new Object[]{file,s});
		}
		catch(Exception e)
		{Outside.err(this,"writeFile(File,JTextComponent)",e);}
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
	
	
	




	private boolean isAutoCompile()
	{
		try {return boolprop.f(KEY_AUTOCOMPILE);}
		catch(Exception e) {Outside.err(this,"isAutoCompile()",e);}
		return false;
	}
	
	
	
	private boolean canEdit(File file)
	{
		if(file==null) return false;
		if(!file.canWrite()) return false;
		return true;
	}
}
