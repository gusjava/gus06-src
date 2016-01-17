package gus06.entity.gus.find.p;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.io.OutputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150829";}


	public EntityImpl() throws Exception
	{
	}
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof P) return obj;
		
		if(obj instanceof PrintStream)
			return new P1((PrintStream) obj);
		if(obj instanceof File)
			return new P1(new PrintStream((File) obj));
		if(obj instanceof OutputStream)
			return new P1(new PrintStream((OutputStream) obj));
		if(obj instanceof StringBuffer)
			return new P2((StringBuffer) obj);
			
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class P1 implements P, G
	{
		private PrintStream p;
		public P1(PrintStream p) {this.p = p;}
		
		public void p(Object obj) throws Exception
		{p.print(obj);}
		
		public Object g() throws Exception
		{return p;}
	}
	
	
	private class P2 implements P, G
	{
		private StringBuffer b;
		public P2(StringBuffer b) {this.b = b;}
		
		public void p(Object obj) throws Exception
		{b.append(obj);}
		
		public Object g() throws Exception
		{return b;}
	}
}
