package gus06.entity.gus.java.srcdir.retrieve.javasrc;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160410";}
	
	private Service readFile;
	private Service findFile;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		findFile = Outside.service(this,"gus.java.srcdir.retrieve.javafile");
	}

	
	public Object t(Object obj) throws Exception
	{
		File javaFile = (File) findFile.t(obj);
		if(javaFile==null || !javaFile.isFile()) return null;
		return readFile.t(javaFile);
	}
}
