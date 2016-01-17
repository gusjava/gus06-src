package gus06.entity.gus.sys.expression1.apply.op._empty;

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
		return new Boolean(empty(obj));
	}
	
	
	
	private boolean empty(Object obj) throws Exception
	{
		if(obj instanceof Map) return ((Map) obj).size()==0;
		if(obj instanceof Collection) return ((Collection) obj).size()==0;
		if(obj instanceof String) return ((String) obj).length()==0;
		if(obj instanceof File) return empty((File) obj);
		
		if(obj instanceof Object[]) return ((Object[]) obj).length==0;
		if(obj instanceof String[]) return ((String[]) obj).length==0;
		if(obj instanceof File[]) return ((File[]) obj).length==0;
		
		if(obj instanceof boolean[]) return ((boolean[]) obj).length==0;
		if(obj instanceof byte[]) return ((byte[]) obj).length==0;
		if(obj instanceof char[]) return ((char[]) obj).length==0;
		if(obj instanceof int[]) return ((int[]) obj).length==0;
		if(obj instanceof long[]) return ((long[]) obj).length==0;
		if(obj instanceof double[]) return ((double[]) obj).length==0;
		if(obj instanceof float[]) return ((float[]) obj).length==0;
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private boolean empty(File file)
	{
		if(file.isFile()) return file.length()==0;
		File[] ff = file.listFiles();
		return ff==null?true:ff.length==0;
	}
}
