package gus06.entity.gus.swing.textarea.buildscrollpane.linenb;

import gus06.framework.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.Color;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140726";}

	public static final Color COLOR_BACKGROUND = new Color(240,240,240);
	public static final Color COLOR_FOREGROUND = new Color(153,153,153);

	

	public Object t(Object obj) throws Exception
	{return new JScrollPane1((JTextComponent) obj);}




	private class JScrollPane1 extends JScrollPane implements DocumentListener, CaretListener
	{
		private JTextComponent comp;
		private Document doc;
		private JTextPane0 lines;
		
		private int lineNb = -1;
		private int indexCaret = -1;


		public JScrollPane1(JTextComponent comp)
		{
			super(comp);
			this.comp = comp;
			doc = comp.getDocument();

			lines = new JTextPane0();
			lines.setBackground(COLOR_BACKGROUND);
			lines.setForeground(COLOR_FOREGROUND);
			lines.setEditable(false);
			setRowHeaderView(lines);

			updateLines();
			
			doc.addDocumentListener(this);
			comp.addCaretListener(this);
		}

		public void changedUpdate(DocumentEvent de)
		{updateLines();}
 
		public void insertUpdate(DocumentEvent de)
		{updateLines();}
 
		public void removeUpdate(DocumentEvent de)
		{updateLines();}

		public void caretUpdate(CaretEvent e)
		{updateLines();}
		
		


		private void updateLines()
		{
			Element root = doc.getDefaultRootElement();
			
			int newLineNb = root.getElementCount();
			int newIndexCaret = root.getElementIndex(comp.getCaretPosition());
			
			if(lineNb == newLineNb && indexCaret == newIndexCaret) return;
			
			lineNb = newLineNb;
			indexCaret = newIndexCaret;

			int first = 1;
			int last = lineNb;
			int maxLength = (""+last).length();
			
			lines.setText("");
			lines.setFont(comp.getFont());
			lines.setMargin(comp.getMargin());
			
			int pos = 0;
			
			for(int i=first;i<=last;i++)
			{
				String n = format(i,maxLength);
				
				if(i==indexCaret+1)
				{
					pos = lines.getDocument().getLength()+1;
					lines.appendBoldText(n+"\n",Color.BLACK);
				}
				else lines.appendText(n+"\n");
			}

			lines.setCaretPosition(pos);
		}


		private String format(int v, int l)
		{
			String s = ""+v;
			while(s.length()<l) s = " "+s;
			return s;
		}
	}
	
	
	
	
	
	private class JTextPane0 extends JTextPane
	{
		private StyledDocument doc;
		private SimpleAttributeSet attr;
		
		public JTextPane0()
		{
			super();
			doc = getStyledDocument();
			attr = new SimpleAttributeSet();
		}
		
		public synchronized void initBold(boolean val)
		{StyleConstants.setBold(attr,val);}
		
		public synchronized void initItalic(boolean val)
		{StyleConstants.setItalic(attr,val);}
		 
		public synchronized void initUnderline(boolean val)
		{StyleConstants.setUnderline(attr,val);}
		
		public synchronized void initForeground(Color color)
		{StyleConstants.setForeground(attr,color);}
		
		public synchronized void initBackground(Color color)
		{StyleConstants.setBackground(attr,color);}
		
		public synchronized void appendText(String text)
		{
			try{doc.insertString(doc.getLength(),text,attr);}
			catch(BadLocationException e){}
		}
		
		public void positionToEnd()
		{setCaretPosition(doc.getLength());}
		
		
		public void appendText(String text, Color color, boolean isBold, boolean isItalic)
		{
			if(isBold) initBold(true);
			if(isItalic) initItalic(true);
			initForeground(color);
			
			appendText(text);
			
			initForeground(getForeground());
			initBold(false);
			initItalic(false);
		}
		
		public void appendBoldText(String text)
		{
			initBold(true);
			
			appendText(text);
			
			initBold(false);
		}
		
		public void appendBoldText(String text, Color color)
		{
			initBold(true);
			initForeground(color);
			
			appendText(text);
			
			initForeground(getForeground());
			initBold(false);
		}
		
		public void setCaretToEnd()
		{setCaretPosition(doc.getLength());}
	}
}
