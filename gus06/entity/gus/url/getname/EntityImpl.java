package gus06.entity.gus.url.getname;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170130";}

	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		String name = url.getFile().split("\\?",2)[0];
		if(name.startsWith("/")) name = name.substring(1);
		return name;
	}
}
