package gus06.entity.gus.data.filter.isempty;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20141021";}
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj instanceof String) return obj.equals("");
		if(obj instanceof Object[]) return ((Object[])obj).length==0;
		if(obj instanceof Collection) return ((Collection)obj).isEmpty();
		if(obj instanceof Map) return ((Map)obj).isEmpty();
		if(obj instanceof File) return ((File)obj).length()==0;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
