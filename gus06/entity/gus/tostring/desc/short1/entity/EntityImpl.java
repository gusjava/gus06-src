package gus06.entity.gus.tostring.desc.short1.entity;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}
	


	public Object t(Object obj) throws Exception
	{
		Entity entity = (Entity) obj;
		Class c = entity.getClass();
		String name = c.getName();
	
		return "Entity: "+name.substring(13,name.length()-11);
	}
}
