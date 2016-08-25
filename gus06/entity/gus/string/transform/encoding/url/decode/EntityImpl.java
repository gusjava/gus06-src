package gus06.entity.gus.string.transform.encoding.url.decode;

import gus06.framework.*;
import java.net.URLDecoder;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160417";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return URLDecoder.decode(s,"UTF-8");
	}
}
