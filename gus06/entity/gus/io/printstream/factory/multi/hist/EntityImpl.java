package gus06.entity.gus.io.printstream.factory.multi.hist;

import gus06.framework.*;
import java.io.*;
import java.util.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140730";}
	
	

	public Object g() throws Exception
	{return new PrintStream1();}
	
	
	
	
	private class PrintStream1 extends PrintStream implements P, V
	{
		private List<PrintStream> l = new ArrayList<>();
		private StringBuffer b = new StringBuffer();
		
		public PrintStream1()
		{
			super(new OutputStreamNull());
			b = new StringBuffer();
		}
	
		public void p(Object obj) throws Exception
		{
			print(obj);
		}
		
		public void v(String key, Object obj) throws Exception
		{
			if(key.equals("add")) {addPrintStream((PrintStream) obj);return;}
			throw new Exception("Unknown key: "+key);
		}
		
		private void addPrintStream(PrintStream p) throws Exception
		{
			if(b.length()>0) p.print(b);
			l.add(p);
		}
	
		public void println()			{b_println();for(PrintStream p:l) p.println();}
		public void println(char[] val)		{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(boolean val)	{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(char val) 		{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(double val) 	{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(float val)    	{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(int val)  		{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(long val) 		{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(Object val)   	{b_println(""+val);for(PrintStream p:l) p.println(val);}
		public void println(String val)		{b_println(val);for(PrintStream p:l) p.println(val);}
	    
		public void print(char[] val)    	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(boolean val)    	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(char val)     	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(double val)      	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(float val)      	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(int val)      	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(long val)     	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(Object val)    	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		public void print(String val)    	{b_print(""+val);for(PrintStream p:l) p.print(val);}
		
		private void b_println()		{b.append("\n");}
		private void b_print(String s)		{b.append(s);}
		private void b_println(String s)	{b.append(s+"\n");}
	}
		
		
		
	private static class OutputStreamNull extends OutputStream
	{
		public OutputStreamNull(){} 
		public void write(int b){}
	}
}
