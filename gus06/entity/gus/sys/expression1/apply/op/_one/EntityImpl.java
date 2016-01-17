package gus06.entity.gus.sys.expression1.apply.op._one;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map)		return one((Map) obj);
		if(obj instanceof Collection)	return one((Collection) obj);
		if(obj instanceof Iterator)	return one((Iterator) obj);
		if(obj instanceof Number)	return one((Number) obj);
		if(obj instanceof boolean[])	return one((boolean[]) obj);
		if(obj instanceof Object[])	return one((Object[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private Boolean one(boolean[] array)
	{
		for(boolean n:array) if(n) return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	
	private Boolean one(Number n)
	{
		return new Boolean(n.doubleValue()==1);
	}
	
	private Object one(Collection c)
	{
		return c.iterator().next();
	}
	
	private Object one(Iterator it)
	{
		if(!it.hasNext()) return null;
		return it.next();
	}
	
	private Object one(Object[] o)
	{
		if(o.length==0) return null;
		return o[0];
	}
	
	private Object one(Map m)
	{
		Object key = one(m.keySet());
		return m.get(key);
	}
	
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
}
