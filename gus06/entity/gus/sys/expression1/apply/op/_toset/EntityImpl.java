package gus06.entity.gus.sys.expression1.apply.op._toset;

import gus06.framework.*;
import java.util.List;
import java.util.HashSet;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Collection;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}


	private Service find;
	private Service read;
	private Service rsToSet;
	
	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.find.set");
		read = Outside.service(this,"gus.file.read.string.set.autodetect");
		rsToSet = Outside.service(this,"gus.jdbc.resultset.tostringset");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Set) return obj;
		
		if(obj instanceof Object[]) return find.t(obj);
		if(obj instanceof int[]) return find.t(obj);
		if(obj instanceof long[]) return find.t(obj);
		if(obj instanceof double[]) return find.t(obj);
		if(obj instanceof boolean[]) return find.t(obj);
		if(obj instanceof char[]) return find.t(obj);
		
		if(obj instanceof List) return new HashSet((List) obj);
		if(obj instanceof Collection) return new HashSet((Collection) obj);
		if(obj instanceof Map) return new HashSet(((Map) obj).keySet());
		if(obj instanceof ResultSet) return rsToSet.t(obj);
		if(obj instanceof File) return read.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
