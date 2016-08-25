package gus06.entity.gus.data.perform.first;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160818";}


	private Service isEmpty;
	
	public EntityImpl() throws Exception
	{
		isEmpty = Outside.service(this,"gus.data.filter.isempty");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(isEmpty.f(obj)) return null;
		
		if(obj instanceof List) return ((List) obj).get(0);
		if(obj instanceof String) return ""+((String) obj).charAt(0);
		
		if(obj instanceof Object[]) return ((Object[]) obj)[0];
		if(obj instanceof boolean[]) return new Boolean(((boolean[]) obj)[0]);
		if(obj instanceof byte[]) return new Byte(((byte[]) obj)[0]);
		if(obj instanceof char[]) return ""+((char[]) obj)[0];
		if(obj instanceof int[]) return new Integer(((int[]) obj)[0]);
		if(obj instanceof long[]) return new Long(((long[]) obj)[0]);
		if(obj instanceof double[]) return new Double(((double[]) obj)[0]);
		if(obj instanceof float[]) return new Float(((float[]) obj)[0]);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
