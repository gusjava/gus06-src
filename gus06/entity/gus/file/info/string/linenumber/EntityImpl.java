package gus06.entity.gus.file.info.string.linenumber;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150609";}


	private Service check;
	private Service info;
	
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.file.string.check");
		info = Outside.service(this,"gus.file.string.info.linenumber");
	}



	public Object t(Object obj) throws Exception
	{
		if(!check.f(obj)) return null;
		return info.t(obj);
	}
}
