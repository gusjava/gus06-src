package gus06.entity.gus.url.connect.rebuildurl;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170202";}

	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		String s = url.toString();
		return new URL(s.replace(" ","%20"));
	}
}
