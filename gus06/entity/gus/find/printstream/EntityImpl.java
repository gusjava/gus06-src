package gus06.entity.gus.find.printstream;

import gus06.framework.*;
import java.io.PrintStream;
import java.io.File;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151024";}


	private Service pToPrintStream;
	private Service textAreaToPrintStream;


	public EntityImpl() throws Exception
	{
		pToPrintStream = Outside.service(this,"gus.convert.ptoprintstream");
		textAreaToPrintStream = Outside.service(this,"gus.io.printstream.textarea1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof PrintStream) return obj;
		if(obj instanceof OutputStream) return new PrintStream((OutputStream) obj);
		if(obj instanceof File) return new PrintStream((File) obj);
		if(obj instanceof P) return pToPrintStream.t(obj);
		if(obj instanceof JTextArea) return textAreaToPrintStream.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
