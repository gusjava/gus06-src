package gus06.entity.gus.sys.expression1.apply.op._first;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151109";}


	private Service empty;
	
	public EntityImpl() throws Exception
	{
		empty = Outside.service(this,"gus.sys.expression1.apply.op._empty");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		Object value = o[0];
		
		if(value==null) return null;
		
		Boolean b = (Boolean) empty.t(obj);
		if(b.booleanValue()) return null;
		
		return first(value);
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{List.class,String.class,Object[].class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	private Object first(Object obj) throws Exception
	{
		if(obj instanceof List) return ((List) obj).get(0);
		if(obj instanceof String) return ""+((String) obj).charAt(0);
		
		if(obj instanceof Object[]) return ((Object[]) obj)[0];
		if(obj instanceof String[]) return ((String[]) obj)[0];
		if(obj instanceof File[]) return ((File[]) obj)[0];
		
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
