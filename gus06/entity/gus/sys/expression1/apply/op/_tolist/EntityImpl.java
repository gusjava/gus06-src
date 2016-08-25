package gus06.entity.gus.sys.expression1.apply.op._tolist;

import gus06.framework.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collection;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	private Service read;
	private Service find;
	
	public EntityImpl() throws Exception
	{
		read = Outside.service(this,"gus.file.read.string.list.autodetect");
		find = Outside.service(this,"gus.find.list");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof List) return obj;
		
		if(obj instanceof Object[]) return find.t(obj);
		if(obj instanceof int[]) return find.t(obj);
		if(obj instanceof long[]) return find.t(obj);
		if(obj instanceof double[]) return find.t(obj);
		if(obj instanceof boolean[]) return find.t(obj);
		if(obj instanceof char[]) return find.t(obj);
		
		if(obj instanceof Set) return new ArrayList((Set) obj);
		if(obj instanceof Collection) return new ArrayList((Collection) obj);
		if(obj instanceof Map) return new ArrayList(((Map) obj).keySet());
		if(obj instanceof File) return read.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
}
