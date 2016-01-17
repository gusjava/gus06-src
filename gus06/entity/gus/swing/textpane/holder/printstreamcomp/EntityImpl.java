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
		OutputStream0 os = buildOutputStream(key);
		return new PrintStream(os,true,"UTF-8");
	}
	
	
	
	private OutputStream0 buildOutputStream(String key) throws Exception
	{
		boolean isBold = false;
		boolean isItalic = false;
		Color color = Color.BLACK;
		
		String[] nn = key.split(" ");
		for(String n:nn)
		{
			if(n.equals("b") || n.equals("bold")) isBold = true;
			else if(n.equals("i") || n.equals("italic")) isItalic = true;
			else color = findColor(n);
		}
		return new OutputStream0(color,isBold,isItalic);
	}
	
	
	private Color findColor(String key) throws Exception
	{return (Color) findColor.t(key);}
	
	
	
	
	private void print(Reader reader, Color color, boolean isBold, boolean isItalic)
	{
		try
		{
			while(reader.ready())
			{
				char[] chars = new char[1024];
					int n = reader.read(chars);
				String txt = new String(chars,0,n);
				
				textPane.appendText(txt,color,isBold,isItalic);
				textPane.setCaretToEnd();
			}
		}
		catch(Exception e)
		{Outside.err(this,"print(Reader,Color,boolean,boolean)",e);}
	}
	
	
	
	private void print(String m, Color color, boolean isBold, boolean isItalic)
	{
		try
		{
			textPane.appendText(m,color,isBold,isItalic);
			textPane.setCaretToEnd();
		}
		catch(Exception e)
		{Outside.err(this,"print(String,Color,boolean,boolean)",e);}
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
		
		public synchronized void appendText(String text) throws BadLocationException
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
	
	
	
	
	
	
	private class OutputStream0 extends OutputStream implements Runnable
	{
		private Color color;
		private boolean isBold;
		private boolean isItalic;
		
		private PipedOutputStream out;
		private PipedInputStream in;
		private Reader reader;
		
		
		public OutputStream0(Color color, boolean isBold, boolean isItalic) throws Exception
		{
			this.color = color;
			this.isBold = isBold;
			this.isItalic = isItalic;
			
			out = new PipedOutputStream();
			in = new PipedInputStream(out);
			reader = new InputStreamReader(in,"UTF-8");
			
			new Thread(this,"THREAD_OutputStream0_"+EntityImpl.class.getName()).start();
		}
	
		public void write(int b) throws IOException
		{out.write(b);}
		
		
		public void flush() throws IOException
		{
			/*if(!reader.ready()) return;
			
			char[] chars = new char[1024];
				int n = reader.read(chars);
			String txt = new String(chars,0,n);
			
			print(txt,color,isBold,isItalic);*/
		}
		
		
		public void run()
		{
			while(true)
			{
				print(reader,color,isBold,isItalic);
				sleep();
			}
		}
	}
	
	
	private void sleep()
	{
		try{Thread.sleep(5);}
		catch(Exception e){}
	}
}
