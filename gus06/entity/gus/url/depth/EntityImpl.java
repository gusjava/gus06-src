package gus06.entity.gus.url.depth;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170113";}
	
	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		String path = url.getPath();
		int depth = path.split("/").length;
		
		return new Integer(depth);
	}
}
