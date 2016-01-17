package gus06.entity.gus.app.entity.nametoclasspath;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140916";}

	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		return "gus06.entity."+name+".EntityImpl";
	}
}
