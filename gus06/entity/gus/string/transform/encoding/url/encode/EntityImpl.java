package gus06.entity.gus.string.transform.encoding.url.encode;

import gus06.framework.*;
import java.net.URLEncoder;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160417";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return URLEncoder.encode(s,"UTF-8");
	}
}
