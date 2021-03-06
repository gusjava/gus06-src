package gus06.entity.gus.crypto.pbe.secretkey.builder.askpwd;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170520";}


	private Service keyBuilder;
	private Service askPwd;
	
	public EntityImpl() throws Exception
	{
		keyBuilder = Outside.service(this,"gus.crypto.pbe.secretkey.builder");
		askPwd = Outside.service(this,"gus.security.askinfo.password1");
	}
	
	public Object g() throws Exception
	{return keyBuilder.t(askPwd.g());}
}