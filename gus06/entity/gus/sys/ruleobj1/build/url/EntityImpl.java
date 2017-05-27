package gus06.entity.gus.sys.ruleobj1.build.url;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170117";}

	
	public Object t(Object obj) throws Exception
	{
		return new URL((String) obj);
	}
}
