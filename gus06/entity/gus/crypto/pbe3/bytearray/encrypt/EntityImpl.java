package gus06.entity.gus.crypto.pbe3.bytearray.encrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170520";}


	private Service encrypt;
	private Service getKey;

	public EntityImpl() throws Exception
	{
		encrypt = Outside.service(this,"gus.crypto.pbe.bytearray.encrypt");
		getKey = Outside.service(this,"gus.crypto.pbe3.secretkey.holder");
	}
	
	public Object t(Object obj) throws Exception
	{
		T t = (T) encrypt.t(getKey.g());
		return t.t(obj);
	}
}