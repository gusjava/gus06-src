package gus06.entity.gus.convert.stringtourl;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150626";}

	
	public Object t(Object obj) throws Exception
	{
		return new URL((String) obj);
	}
}
