package gus06.entity.gus.entitydev.retrieve.srccode;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140713";}


	private Service retrieveFile;
	private Service readFile;
	
	
	public EntityImpl() throws Exception
	{
		retrieveFile = Outside.service(this,"gus.entitydev.retrieve.javafile");
		readFile = Outside.service(this,"gus.file.read.string");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) retrieveFile.t(obj);
		if(file==null || !file.exists()) return null;
		return readFile.t(file);
	}
}
