package gus06.entity.gus.crypto.pbe3.secretkey.holder;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20151115";}


	private Service keyBuilder;
	
	public EntityImpl() throws Exception
	{
		keyBuilder = Outside.service(this,"gus.crypto.pbe.secretkey.builder.askpwd");
	}
	
	public Object g() throws Exception
	{return keyBuilder.g();}
}
