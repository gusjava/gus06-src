package gus06.entity.gus.crypto.pbe2.bytearray.decrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170520";}


	private Service decrypt;
	private Service getKey;
	private T t;
	
	public EntityImpl() throws Exception
	{
		decrypt = Outside.service(this,"gus.crypto.pbe.bytearray.decrypt");
		getKey = Outside.service(this,"gus.crypto.pbe2.secretkey.holder");
	}
	
	public Object t(Object obj) throws Exception
	{
		if(t==null) t = (T) decrypt.t(getKey.g());
		return t.t(obj);
	}
}
