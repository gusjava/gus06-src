package gus06.entity.gus.file.read.string.csv;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160723";}


	private Service read;
	private Service build;


	public EntityImpl() throws Exception
	{
		read = Outside.service(this,"gus.file.read.string");
		build = Outside.service(this,"gus.file.convert.csv.parser");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) read.t(obj);
		return build.t(text);
	}
}
