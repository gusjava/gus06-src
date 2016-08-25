package gus06.entity.gus.swing.textpane.holder.printstreamcomp;

import gus06.framework.*;

import javax.swing.JComponent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PipedOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.awt.Dimension;


public class EntityImpl implements Entity, I, R {

	public String creationDate() {return "20150101";}


	private Service findColor;
	private JTextPane0 textPane;

	public EntityImpl() throws Exception
	{
		findColor = Outside.service(this,"gus.convert.stringtocolor");
		textPane = new JTextPane0();
	}
	
	
	public Object i() throws Exception
	{return textPane;}
	
	
	
	public Object r(String key) throws Exception
	{
		boolean isBold = false;
		boolean isItalic = false;
		Color color = Color.BLACK;
		
		String[] nn = key.split(" ");
		for(String n:nn)
		{
			if(n.equals("b") || n.equals("bold")) isBold = true;
			else if(n.equals("i") || n.equals("italic")) isItalic = true;
			else color = (Color) findColor.t(n);
		}
		return new PrintStream0(color,isBold,isItalic);
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
		
		public void initBold(boolean val)
		{StyleConstants.setBold(attr,val);}
		
		public void initItalic(boolean val)
		{StyleConstants.setItalic(attr,val);}
		 
		public void initUnderline(boolean val)
		{StyleConstants.setUnderline(attr,val);}
		
		public void initForeground(Color color)
		{StyleConstants.setForeground(attr,color);}
		
		public void initBackground(Color color)
		{StyleConstants.setBackground(attr,color);}
		
		public void appendText(String text) throws BadLocationException
		{doc.insertString(doc.getLength(),text,attr);}
		
		public void positionToEnd()
		{setCaretPosition(doc.getLength());}
		
		
		public void appendText(String text, Color color, boolean isBold, boolean isItalic) throws BadLocationException
		{
			if(isBold) initBold(true);
			if(isItalic) initItalic(true);
			initForeground(color);
			
			appendText(text);
			
			initForeground(Color.BLACK);
			initBold(false);
			initItalic(false);
		}
		
		public void setCaretToEnd()
		{setCaretPosition(doc.getLength());}
		
		public void setSize(Dimension d)
		{
			if(d.width < getParent().getSize().width)
			d.width = getParent().getSize().width;
			super.setSize(d);
		}
			
		public boolean getScrollableTracksViewportWidth()
		{return false;}
	}
	
	
	
	
	private void send(String m, Color color, boolean isBold, boolean isItalic)
	{
		try
		{
			textPane.appendText(m,color,isBold,isItalic);
			textPane.setCaretToEnd();
		}
		catch(Exception e)
		{Outside.err(this,"send(String,Color,boolean,boolean)",e);}
	}
	
	
	
	
	
	private class PrintStream0 extends PrintStream
	{
		private Color color;
		private boolean b;
		private boolean i;
		
		public PrintStream0(Color color, boolean b, boolean i) throws Exception
		{
			super(new OutputStreamNull());
			
			this.color = color;
			this.b = b;
			this.i = i;
		}
	
		public void println()			{send("\n",color,b,i);}
		public void println(char[] val)		{send(val+"\n",color,b,i);}
		public void println(boolean val)	{send(val+"\n",color,b,i);}
		public void println(char val) 		{send(val+"\n",color,b,i);}
		public void println(double val) 	{send(val+"\n",color,b,i);}
		public void println(float val)    	{send(val+"\n",color,b,i);}
		public void println(int val)  		{send(val+"\n",color,b,i);}
		public void println(long val) 		{send(val+"\n",color,b,i);}
		public void println(Object val)   	{send(val+"\n",color,b,i);}
		public void println(String val)		{send(val+"\n",color,b,i);}
	    
		public void print(char[] val)    	{send(""+val,color,b,i);}
		public void print(boolean val)    	{send(""+val,color,b,i);}
		public void print(char val)     	{send(""+val,color,b,i);}
		public void print(double val)      	{send(""+val,color,b,i);}
		public void print(float val)      	{send(""+val,color,b,i);}
		public void print(int val)      	{send(""+val,color,b,i);}
		public void print(long val)     	{send(""+val,color,b,i);}
		public void print(Object val)    	{send(""+val,color,b,i);}
		public void print(String val)    	{send(""+val,color,b,i);}
	}
	
	
	private static class OutputStreamNull extends OutputStream
	{
		public OutputStreamNull(){} 
		public void write(int b){}
	}
}
