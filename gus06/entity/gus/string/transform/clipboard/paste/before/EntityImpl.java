package gus06.entity.gus.string.transform.clipboard.paste.before;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160517";}


	private Service clipboard;
	
	public EntityImpl() throws Exception
	{
		clipboard = Outside.service(this,"gus.clipboard.access.string");
	}

	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String c = (String) clipboard.g();
		return c+s;
	}
}
