package gus06.entity.gus.data.perform.pick;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.util.Iterator;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160806";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Map)		return pick((Map) obj);
		if(obj instanceof Collection)	return pick((Collection) obj);
		if(obj instanceof Iterator)	return pick((Iterator) obj);
		if(obj instanceof Object[])	return pick((Object[]) obj);
		if(obj instanceof File)		return pick((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private Object pick(Collection c)
	{
		return c.iterator().next();
	}
	
	private Object pick(Iterator it)
	{
		if(!it.hasNext()) return null;
		return it.next();
	}
	
	private Object pick(Object[] o)
	{
		if(o.length==0) return null;
		return o[0];
	}
	
	private Object pick(Map m)
	{
		Object key = pick(m.keySet());
		return m.get(key);
	}
	
	private Object pick(File dir)
	{
		File[] ff = dir.listFiles();
		if(ff==null || ff.length==0) return null;
		return ff[0];
	}
}
