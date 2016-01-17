package gus06.entity.gus.file.read.string.from.txt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150617";}


	private Service textFromTxt;


	public EntityImpl() throws Exception
	{
		textFromTxt = Outside.service(this,"gus.file.read.string.autodetect");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return textFromTxt.t(obj);
	}
}
