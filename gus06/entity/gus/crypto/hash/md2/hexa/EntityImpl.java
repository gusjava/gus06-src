package gus06.entity.gus.crypto.hash.md2.hexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151014";}

	private Service md2;
	private Service hexa;

	public EntityImpl() throws Exception
	{
		md2 = Outside.service(this,"gus.crypto.hash.md2");
		hexa = Outside.service(this,"gus.tostring.bytetohexa");
	}
	
	public Object t(Object obj) throws Exception
	{return hexa.t(md2.t(obj));}
}
