package gus06.entity.gus.java.srcfile.extract.entity.name;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140727";}

	private Service readFile;
	private Service srcToName;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		srcToName = Outside.service(this,"gus.java.srccode.extract.entity.name");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String src = (String) readFile.t(obj);
		return srcToName.t(src);
	}
}
