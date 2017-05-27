package gus06.entity.gus.crypto.tool.decrypt.string;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170520";}


	private Service toByteArray;
	
	public EntityImpl() throws Exception
	{
		toByteArray = Outside.service(this,"gus.convert.stringtobytearray.hexa");
	}

	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		T t = (T) o[0];
		String data = (String) o[1];
		
		byte[] b0 = (byte[]) toByteArray.t(data);
		byte[] b1 = (byte[]) t.t(b0);
		
		return new String(b1,"UTF-8");
	}
}
