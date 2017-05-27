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
		
		if(obj instanceof double[])	return pick((double[]) obj);
		if(obj instanceof float[])	return pick((float[]) obj);
		if(obj instanceof long[])	return pick((long[]) obj);
		if(obj instanceof int[])	return pick((int[]) obj);
		if(obj instanceof boolean[])	return pick((boolean[]) obj);
		if(obj instanceof byte[])	return pick((byte[]) obj);
		if(obj instanceof short[])	return pick((short[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private Object pick(Collection c)
	{
		if(c.isEmpty()) return null;
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
	
	
	
	private Object pick(double[] o)
	{
		if(o.length==0) return null;
		return new Double(o[0]);
	}
	
	private Object pick(float[] o)
	{
		if(o.length==0) return null;
		return new Float(o[0]);
	}
	
	private Object pick(int[] o)
	{
		if(o.length==0) return null;
		return new Integer(o[0]);
	}
	
	private Object pick(long[] o)
	{
		if(o.length==0) return null;
		return new Long(o[0]);
	}
	
	private Object pick(boolean[] o)
	{
		if(o.length==0) return null;
		return new Boolean(o[0]);
	}
	
	private Object pick(byte[] o)
	{
		if(o.length==0) return null;
		return new Byte(o[0]);
	}
	
	private Object pick(short[] o)
	{
		if(o.length==0) return null;
		return new Short(o[0]);
	}
}
