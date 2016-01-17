package gus06.entity.gus.java.srcfile.extract.entity.dependencies;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150312";}

	private Service readFile;
	private Service extract;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		extract = Outside.service(this,"gus.java.srccode.extract.entity.dependencies");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String src = (String) readFile.t(obj);
		return extract.t(src);
	}
}
