package gus06.entity.gus.tostring.desc.short1.url;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170111";}



	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		return "URL: "+url;
	}
}
