package gus06.entity.gus.data.perform.size;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160818";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof File)
			return fileSize((File) obj);
		return new Integer(size(obj));
	}
	
	
	
	private int size(Object obj) throws Exception
	{
		if(obj instanceof Map) return ((Map) obj).size();
		if(obj instanceof Set) return ((Set) obj).size();
		if(obj instanceof List) return ((List) obj).size();
		
		if(obj instanceof String) return ((String) obj).length();
		if(obj instanceof Number) return (""+obj).length();
		if(obj instanceof Boolean) return (""+obj).length();
		
		if(obj instanceof Object[]) return ((Object[]) obj).length;
		if(obj instanceof boolean[]) return ((boolean[]) obj).length;
		if(obj instanceof byte[]) return ((byte[]) obj).length;
		if(obj instanceof char[]) return ((char[]) obj).length;
		if(obj instanceof int[]) return ((int[]) obj).length;
		if(obj instanceof long[]) return ((long[]) obj).length;
		if(obj instanceof double[]) return ((double[]) obj).length;
		if(obj instanceof float[]) return ((float[]) obj).length;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Object fileSize(File file)
	{
		if(!file.exists()) return null;
		if(file.isFile()) return new Long(file.length());
		
		File[] ff = file.listFiles();
		return new Integer(ff==null?0:ff.length);
	}
}
