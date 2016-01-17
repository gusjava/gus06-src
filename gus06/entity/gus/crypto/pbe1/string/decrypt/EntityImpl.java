package gus06.entity.gus.crypto.pbe1.string.decrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}


	private Service decrypt;
	private Service getKey;
	private T t;
	
	public EntityImpl() throws Exception
	{
		decrypt = Outside.service(this,"gus.crypto.pbe.string.decrypt");
		getKey = Outside.service(this,"gus.crypto.pbe1.secretkey.holder");
	}
	
	public Object t(Object obj) throws Exception
	{
		if(t==null) t = (T) decrypt.t(getKey.g());
		return t.t(obj);
	}
}
