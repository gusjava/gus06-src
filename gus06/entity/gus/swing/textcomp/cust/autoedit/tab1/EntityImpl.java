package gus06.entity.gus.swing.textcomp.cust.autoedit.tab1;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160410";}




	public void p(Object obj) throws Exception
	{new Holder1((JTextComponent) obj);}




	private class Holder1 implements KeyListener
	{
		private JTextComponent comp;
		public Holder1(JTextComponent comp)
		{
			this.comp = comp;
			comp.addKeyListener(this);
		}
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode()==KeyEvent.VK_TAB)
			{
				if(is_shift(e)) handleTabInv();
				else handleTab();
			}
		}
		
		private void handleTab()
		{
			String selection = comp.getSelectedText();
			if(selection==null || !selection.contains("\n")) return;
			
			String s0 = moveRight(selection);
			SwingUtilities.invokeLater(new Holder2(comp,s0));
		}
		
		private void handleTabInv()
		{
			String selection = comp.getSelectedText();
			if(selection==null || !selection.contains("\n")) return;
			
			selection = widdenSelection(selection,comp);
			String s0 = moveLeft(selection);
			SwingUtilities.invokeLater(new Holder2(comp,s0));
		}
		
	}
	
	
	
	private class Holder2 implements Runnable
	{
		private JTextComponent comp;
		private String s0;
		
		public Holder2(JTextComponent comp, String s0)
		{
			this.comp = comp;
			this.s0 = s0;
		}
		public void run()
		{replaceText(comp,s0);}
	}
	
	
	
	
	private void replaceText(JTextComponent comp, String s0)
	{
		try
		{
			if(!hasSelection(comp))
			{
				int pos = comp.getCaretPosition();
				if(pos==0) throw new Exception("UNEXPECTED: Invalid caret position after tab press: 0");
				comp.select(pos-1,pos);
			}
			
			int start = comp.getSelectionStart();
			comp.replaceSelection(s0);
			comp.select(start,start+s0.length());
		}
		catch(Exception e)
		{Outside.err(this,"replaceText(JTextComponent,String)",e);}
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{return comp.getSelectedText()!=null && comp.getSelectedText().length()>0;}
	
	
	
	private String moveRight(String s)
	{
		StringBuffer b = new StringBuffer();
		String[] line = s.split("\n");
		for(int i=0;i<line.length;i++)
		{
			b.append("\t"+line[i]+"\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	private String moveLeft(String s)
	{
		StringBuffer b = new StringBuffer();
		String[] line = s.split("\n");
		for(int i=0;i<line.length;i++)
		{
			if(line[i].startsWith("\t")) line[i] = line[i].substring(1);
			b.append(line[i]+"\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}

	
	private boolean is_shift(KeyEvent e)
	{return e.getModifiers() == KeyEvent.SHIFT_MASK;}
	
	
	
	
	private String widdenSelection(String selection, JTextComponent comp)
	{
		if(selection.startsWith("\t")) 	return selection;
		
		int start = comp.getSelectionStart();
		if(start==0) return selection;
		
		char c = comp.getText().charAt(start-1);
		if(c!='\t') return selection;
		
		int end = comp.getSelectionEnd();
		comp.select(start-1,end);
		
		return "\t"+selection;
	}
}
