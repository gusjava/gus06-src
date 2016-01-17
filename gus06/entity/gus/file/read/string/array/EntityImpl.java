package gus06.entity.gus.file.read.string.array;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140926";}


	private Service read;


	public EntityImpl() throws Exception
	{read = Outside.service(this,"gus.file.read.string");}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) read.t(obj);
		return text.replace("\r","").split("\n");
	}
}
