package gus06.entity.gus.string.transform.crypto.pbe3.encrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}


	private Service s;

	public EntityImpl() throws Exception
	{s = Outside.service(this,"gus.crypto.pbe3.string.encrypt");}
	
	public Object t(Object obj) throws Exception
	{return s.t(obj);}
}
