package gus06.entity.gus.java.srcfile.extract.entity.calls.service;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150311";}

	private Service readFile;
	private Service srcToCalls;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		srcToCalls = Outside.service(this,"gus.java.srccode.extract.entity.calls.service");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String src = (String) readFile.t(obj);
		return srcToCalls.t(src);
	}
}
