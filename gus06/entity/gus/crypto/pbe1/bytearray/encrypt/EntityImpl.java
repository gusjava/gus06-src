package gus06.entity.gus.crypto.pbe1.bytearray.encrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150626";}


	private Service encrypt;
	private Service getKey;
	private T t;

	
	public EntityImpl() throws Exception
	{
		encrypt = Outside.service(this,"gus.crypto.pbe.bytearray.encrypt");
		getKey = Outside.service(this,"gus.crypto.pbe1.secretkey.holder");
		t = (T) encrypt.t(getKey.g());
	}
	
	public Object t(Object obj) throws Exception
	{return t.t(obj);}
}