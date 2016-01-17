package gus06.entity.gus.file.read.string.from.properties;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150620";}


	private Service textFromProp;


	public EntityImpl() throws Exception
	{
		textFromProp = Outside.service(this,"gus.file.properties.filetostring");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return textFromProp.t(obj);
	}
}
