package gus06.entity.gus.sys.expression1.apply.op._size;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return size((File) obj);
		return new Integer(size(obj));
	}
	
	
	
	private int size(Object obj) throws Exception
	{
		if(obj instanceof Map) return ((Map) obj).size();
		if(obj instanceof Collection) return ((Collection) obj).size();
		
		if(obj instanceof String) return ((String) obj).length();
		
		if(obj instanceof Integer) return (""+obj).length();
		if(obj instanceof Double) return (""+obj).length();
		if(obj instanceof Float) return (""+obj).length();
		if(obj instanceof Long) return (""+obj).length();
		if(obj instanceof Boolean) return (""+obj).length();
		
		if(obj instanceof Object[]) return ((Object[]) obj).length;
		if(obj instanceof String[]) return ((String[]) obj).length;
		if(obj instanceof File[]) return ((File[]) obj).length;
		
		if(obj instanceof boolean[]) return ((boolean[]) obj).length;
		if(obj instanceof byte[]) return ((byte[]) obj).length;
		if(obj instanceof char[]) return ((char[]) obj).length;
		if(obj instanceof int[]) return ((int[]) obj).length;
		if(obj instanceof long[]) return ((long[]) obj).length;
		if(obj instanceof double[]) return ((double[]) obj).length;
		if(obj instanceof float[]) return ((float[]) obj).length;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Object size(File file)
	{
		if(file.isFile()) return new Long(file.length());
		
		File[] ff = file.listFiles();
		int val = ff==null?0:ff.length;
		return new Integer(val);
	}
}
