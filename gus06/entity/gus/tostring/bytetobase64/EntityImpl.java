package gus06.entity.gus.tostring.bytetobase64;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141010";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof byte[])
			return new String(Base64Coder.encode((byte[])obj));
		throw new Exception("Invalid data type: "+obj);
	}
}
