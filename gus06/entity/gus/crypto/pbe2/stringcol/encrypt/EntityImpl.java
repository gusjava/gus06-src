package gus06.entity.gus.crypto.pbe2.stringcol.encrypt;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}


	private Service encrypt;
	private Service getKey;
	private T t;

	public EntityImpl() throws Exception
	{
		encrypt = Outside.service(this,"gus.crypto.pbe.stringcol.encrypt");
		getKey = Outside.service(this,"gus.crypto.pbe2.secretkey.holder");
	}
	
	public Object t(Object obj) throws Exception
	{
		if(t==null) t = (T) encrypt.t(getKey.g());
		return t.t(obj);
	}
}