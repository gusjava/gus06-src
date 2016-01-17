package gus06.entity.gus.file.info.string.wordnumber;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150823";}


	private Service check;
	private Service info;
	
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.file.string.check");
		info = Outside.service(this,"gus.file.string.info.wordnumber");
	}



	public Object t(Object obj) throws Exception
	{
		if(!check.f(obj)) return null;
		return info.t(obj);
	}
}
