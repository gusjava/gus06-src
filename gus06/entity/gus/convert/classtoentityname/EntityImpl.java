package gus06.entity.gus.convert.classtoentityname;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160507";}

	
	public Object t(Object obj) throws Exception
	{
		Class c = (Class) obj;
		String name = c.getName();
		
		if(!name.endsWith(".EntityImpl")) return null;
		if(!name.startsWith("gus06.entity.")) return null;
		
		return name.substring(13,name.length()-11);
	}
}
