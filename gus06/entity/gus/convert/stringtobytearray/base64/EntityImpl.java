package gus06.entity.gus.convert.stringtobytearray.base64;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141015";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String)
			return Base64Coder.decode((String) obj);
		throw new Exception("Invalid data type: "+obj);
	}
}
