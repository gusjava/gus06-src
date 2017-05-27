package gus06.entity.gus.crypto.pbe4.object.encrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170520";}


	private Service encrypt;
	private Service getKey;
	
	public EntityImpl() throws Exception
	{
		encrypt = Outside.service(this,"gus.crypto.pbe.object.encrypt");
		getKey = Outside.service(this,"gus.crypto.pbe4.secretkey.holder");
	}
	
	public Object t(Object obj) throws Exception
	{
		return encrypt.t(getKey.t(obj));
	}
}
