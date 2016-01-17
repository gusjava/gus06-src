package gus06.entity.gus.crypto.asymkeys.signature.dsa.sign2.hexa;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141015";}


	private Service sign;
	private Service toHexa;


	public EntityImpl() throws Exception
	{
		sign = Outside.service(this,"gus.crypto.asymkeys.signature.dsa.sign2");
		toHexa = Outside.service(this,"gus.tostring.bytetohexa");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		byte[] b = (byte[]) sign.t(obj);
		return toHexa.t(b);
	}
}
