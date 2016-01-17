package gus06.entity.gus.string.transform.url.http.complete;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141023";}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(!s.startsWith("http://"))
			return "http://"+s;
		return s;
	}
}
