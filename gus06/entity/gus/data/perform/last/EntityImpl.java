package gus06.entity.gus.data.perform.last;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160818";}


	private Service getSize;
	
	public EntityImpl() throws Exception
	{
		getSize = Outside.service(this,"gus.data.perform.size");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object size = getSize.t(obj);
		if(!(size instanceof Integer)) return null;
		int nb = ((Integer) size).intValue();
		
		if(nb==0) return null;
		int index = nb-1;
		
		if(obj instanceof List) return ((List) obj).get(index);
		if(obj instanceof String) return ""+((String) obj).charAt(index);
		
		if(obj instanceof Object[]) return ((Object[]) obj)[index];
		if(obj instanceof boolean[]) return new Boolean(((boolean[]) obj)[index]);
		if(obj instanceof byte[]) return new Byte(((byte[]) obj)[index]);
		if(obj instanceof char[]) return ""+((char[]) obj)[index];
		if(obj instanceof int[]) return new Integer(((int[]) obj)[index]);
		if(obj instanceof long[]) return new Long(((long[]) obj)[index]);
		if(obj instanceof double[]) return new Double(((double[]) obj)[index]);
		if(obj instanceof float[]) return new Float(((float[]) obj)[index]);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
