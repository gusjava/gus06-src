package gus06.entity.gus.swing.textcomp.cust.autoedit.offset.perform;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140815";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		if(comp instanceof JTextArea) handleTextArea(comp);
		else if(comp instanceof JTextPane) handleTextPane(comp);
	}
	
	
	
	
	private void handleTextArea(JTextComponent comp) throws Exception
	{
		int pos = comp.getCaretPosition();
		
		String text = comp.getText();
		String text0 = text.substring(0,pos);
		
		comp.getDocument().insertString(pos,build(text0),null);
	}
	
	
	
	private void handleTextPane(JTextComponent comp) throws Exception
	{
		// a faire...
	}
	
	
	private String build(String text0) throws Exception
	{
		String[] n = text0.split("\n",-1);
		if(n.length==1) return "";
		String line = n[n.length-2];

		StringBuilder b = new StringBuilder();
		int index = 0;
		while(index<line.length() && line.charAt(index)=='\t')
		{b.append('\t');index++;}
		
		return b.toString();
	}
}
