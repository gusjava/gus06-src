package gus06.entity.gus.url.getextension;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170113";}

	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		String name = url.getFile().split("\\?")[0];
		if(!name.contains(".")) return "";
		
		String[] n = name.split("\\.");
		return n[n.length-1];
	}
}
