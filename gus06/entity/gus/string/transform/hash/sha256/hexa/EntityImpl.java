package gus06.entity.gus.string.transform.hash.sha256.hexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151014";}


	private Service t;


	public EntityImpl() throws Exception
	{
		t = Outside.service(this,"gus.crypto.hash.sha256.hexa");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		return t.t(text);
	}
}
