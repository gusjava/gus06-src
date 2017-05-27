package gus06.entity.gus.java.srcfile.extract.classname;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170220";}


	private Service readFile;
	private Service srcToClassName;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		srcToClassName = Outside.service(this,"gus.java.srccode.extract.classname");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File srcFile = (File) obj;
		
		try
		{
			String src = (String) readFile.t(srcFile);
			String className = (String) srcToClassName.t(src);
			return className;
		}
		catch(Exception e)
		{
			String message = "Failed to extract classname for java file: "+srcFile;
			throw new Exception(message,e);
		}
	}
}
