package gus06.entity.gus.entitydev.retrieve.dependencies1;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150312";}


	private Service retrieveFile;
	private Service extract;


	public EntityImpl() throws Exception
	{
		retrieveFile = Outside.service(this,"gus.entitydev.retrieve.javafile1");
		extract = Outside.service(this,"gus.java.srcfile.extract.entity.dependencies1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		File file = (File) retrieveFile.t(entityName);
		return extract.t(file);
	}
}
