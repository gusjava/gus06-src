package gus06.entity.gus.file.editor.ext.java.high.err;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140728";}


	private Service errorHolder;
	private Service errorHighlighter;
	
	public EntityImpl() throws Exception
	{
		errorHolder = Outside.service(this,"gus.java.compiler.errorholder");
		errorHighlighter = Outside.service(this,"gus.java.compiler.errorhighlighter");
	}
	
	
	public Object t(Object obj) throws Exception
	{return new Holder((JTextComponent) obj);}
	
	
	
	private class Holder implements P, ActionListener
	{
		private JTextComponent comp;
		private File file;
		private P high;
		
		public Holder(JTextComponent comp) throws Exception
		{
			this.comp = comp;
			high = (P) errorHighlighter.t(comp);
			errorHolder.addActionListener(this);
		}
		
		public void p(Object obj) throws Exception
		{
			file = (File) obj;
			checkForErrors(high,file);
		}
		
		public void actionPerformed(ActionEvent e)
		{checkForErrors(high,file);}
	}
	
	
	
	
	
	
	private void checkForErrors(P high, File file)
	{
		if(file==null || !file.exists()) return;
		try{high.p(errorHolder.t(file));}
		catch(Exception e)
		{Outside.err(this,"checkForErrors(P,File)",e);}
	}
}
