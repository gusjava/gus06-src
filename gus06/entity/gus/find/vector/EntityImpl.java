package gus06.entity.gus.find.vector;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140908";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Vector) return obj;
		if(obj instanceof Collection) return new Vector((Collection) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
