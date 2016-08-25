package gus06.entity.gus.io.printstream.textarea1;

import gus06.framework.*;
import javax.swing.JTextArea;
import java.io.PrintStream;
import java.io.OutputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160417";}
	
	
	public Object t(Object obj) throws Exception
	{return new PrintStreamJTextArea((JTextArea) obj);}
	
	
	private class PrintStreamJTextArea extends PrintStream
	{
		private JTextArea gui;
		
		public PrintStreamJTextArea(JTextArea gui)
		{
			super(nullOutput);
			this.gui = gui;
		}
		
		public void println()			{println("");}
		public void println(char[] val)		{println(new String(val));}
		public void println(boolean val)	{println(""+val);}
		public void println(char val)		{println(""+val);}
		public void println(double val)		{println(""+val);}
		public void println(float val)		{println(""+val);}
		public void println(int val)		{println(""+val);}
		public void println(long val)		{println(""+val);}
		public void println(Object val)		{println(""+val);}
		
		public void print(char[] val)		{print(new String(val));}
		public void print(boolean val)		{print(""+val);}
		public void print(char val)		{print(""+val);}
		public void print(double val)		{print(""+val);}
		public void print(float val)		{print(""+val);}
		public void print(int val)		{print(""+val);}
		public void print(long val)		{print(""+val);}
		public void print(Object val)		{print(""+val);}
		
		public void print(String m)
		{
			gui.append(m);
			gui.setCaretPosition(gui.getDocument().getLength());
		}
		
		public void println(String m)
		{
			gui.append(m+"\n");
			gui.setCaretPosition(gui.getDocument().getLength());
		}
	}
	
	
	private static final OutputStreamNull nullOutput = new OutputStreamNull();
	
	private static class OutputStreamNull extends OutputStream
	{
		public OutputStreamNull(){} 
		public void write(int b){}
	}
}
