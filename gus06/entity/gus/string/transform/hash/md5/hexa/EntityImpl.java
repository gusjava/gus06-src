package gus06.entity.gus.string.transform.hash.md5.hexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150301";}


	private Service t;


	public EntityImpl() throws Exception
	{
		t = Outside.service(this,"gus.crypto.hash.md5.hexa");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		return t.t(text);
	}
}
