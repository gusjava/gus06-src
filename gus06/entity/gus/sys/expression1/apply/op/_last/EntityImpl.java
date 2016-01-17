package gus06.entity.gus.sys.expression1.apply.op._last;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service size;
	
	public EntityImpl() throws Exception
	{
		size = Outside.service(this,"gus.sys.expression1.apply.op._size");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		Object value = o[0];
		
		if(value==null) return null;
		
		int n = ((Integer) size.t(obj)).intValue();
		if(n==0) return null;
		
		return last(value,n-1);
	}
	
	
	
	private Object last(Object obj, int index) throws Exception
	{
		if(obj instanceof List) return ((List) obj).get(index);
		if(obj instanceof String) return ""+((String) obj).charAt(index);
		
		if(obj instanceof Object[]) return ((Object[]) obj)[index];
		if(obj instanceof String[]) return ((String[]) obj)[index];
		if(obj instanceof File[]) return ((File[]) obj)[index];
		
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
