package gus06.entity.gus.find.printstream;

import gus06.framework.*;
import java.io.PrintStream;
import java.io.File;
import java.io.OutputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151024";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof PrintStream) return (PrintStream) obj;
		if(obj instanceof OutputStream) return new PrintStream((OutputStream) obj);
		if(obj instanceof File) return new PrintStream((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
