package gus06.entity.gus.crypto.hash.md5.hexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140704";}

	private Service md5;
	private Service hexa;

	public EntityImpl() throws Exception
	{
		md5 = Outside.service(this,"gus.crypto.hash.md5");
		hexa = Outside.service(this,"gus.tostring.bytetohexa");
	}
	
	public Object t(Object obj) throws Exception
	{return hexa.t(md5.t(obj));}
}
