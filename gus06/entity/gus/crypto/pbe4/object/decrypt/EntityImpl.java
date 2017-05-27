package gus06.entity.gus.crypto.pbe4.object.decrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170520";}


	private Service decrypt;
	private Service getKey;
	
	public EntityImpl() throws Exception
	{
		decrypt = Outside.service(this,"gus.crypto.pbe.object.decrypt");
		getKey = Outside.service(this,"gus.crypto.pbe4.secretkey.holder");
	}
	
	public Object t(Object obj) throws Exception
	{
		return decrypt.t(getKey.t(obj));
	}
}
