package gus06.entity.gus.java.srcfile.extract.gyem.build;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140906";}

	private Service readFile;
	private Service srcToBuild;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		srcToBuild = Outside.service(this,"gus.java.srccode.extract.gyem.build");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String src = (String) readFile.t(obj);
		return srcToBuild.t(src);
	}
}
