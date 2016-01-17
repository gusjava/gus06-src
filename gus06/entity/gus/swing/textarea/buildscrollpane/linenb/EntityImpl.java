package gus06.entity.gus.swing.textarea.buildscrollpane.linenb;

import gus06.framework.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.Element;
import javax.swing.text.Document;
import java.awt.Color;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140726";}

	public static final Color COLOR = new Color(240,240,240);

	

	public Object t(Object obj) throws Exception
	{return new JScrollPane1((JTextComponent) obj);}




	private class JScrollPane1 extends JScrollPane implements DocumentListener, CaretListener
	{
		private JTextComponent comp;
		private Document doc;
		private JTextArea lines;
		private int lineNb = 0;

		public JScrollPane1(JTextComponent comp)
		{
			super(comp);
			this.comp = comp;
			doc = comp.getDocument();
			doc.addDocumentListener(this);
			comp.addCaretListener(this);

			lines = new JTextArea(" ");
			lines.setBackground(COLOR);
			lines.setEditable(false);
			setRowHeaderView(lines);

			synCaret();
			updateLines();
		}

		public void changedUpdate(DocumentEvent de)
		{updateLines();}
 
		public void insertUpdate(DocumentEvent de)
		{updateLines();}
 
		public void removeUpdate(DocumentEvent de)
		{updateLines();}

		public void caretUpdate(CaretEvent e)
		{synCaret();}
		

		private void synCaret()
		{if(comp.getCaretPosition()==0) lines.setCaretPosition(0);}


		private void updateLines()
		{
			Element root = doc.getDefaultRootElement();
			int newLineNb = root.getElementCount();

			if(lineNb==newLineNb) return;
			lineNb = newLineNb;

			int first = 1;
			int last = lineNb;
			int maxLength = (""+last).length();
			
			StringBuffer b = new StringBuffer();
			for(int i=first;i<=last;i++) b.append(format(i,maxLength)+"\n");

			synFont();
			lines.setText(b.toString());
		}

		private String format(int v, int l)
		{
			String s = ""+v;
			while(s.length()<l) s = "0"+s;
			return s;
		}

		private void synFont()
		{
			lines.setFont(comp.getFont());
			lines.setMargin(comp.getMargin());
		}
	}
}
