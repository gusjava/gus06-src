package gus06.entity.gus.java.srcfile.extract.framework.isframework;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20141110";}

	private Service readFile;
	private Service isFramework;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		isFramework = Outside.service(this,"gus.java.srccode.extract.framework.isframework");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String src = (String) readFile.t(obj);
		return isFramework.f(src);
	}
}
