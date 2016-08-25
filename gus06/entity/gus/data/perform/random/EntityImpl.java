package gus06.entity.gus.data.perform.random;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160819";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Integer) return new Integer(random(toInt(obj)));
		if(obj instanceof Boolean) return new Boolean(Math.random()<0.5);
		if(obj instanceof String) return random((String) obj);
		if(obj instanceof List) return random((List) obj);
		if(obj instanceof Set) return random((Set) obj);
		if(obj instanceof Map) return random((Map) obj);
		if(obj instanceof Object[]) return random((Object[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private int toInt(Object obj)
	{return ((Integer) obj).intValue();}
	
	
	private int random(int n)
	{return (int) (Math.random()*n);}
	
	
	private Object random(List list)
	{
		if(list.isEmpty()) return null;
		return list.get(random(list.size()));
	}
	
	
	private Object random(String s)
	{
		if(s.length()==0) return null;
		return ""+s.charAt(random(s.length()));
	}
	
	
	private Object random(Object[] array)
	{
		if(array.length==0) return null;
		return array[random(array.length)];
	}
	
	
	private Object random(Map m)
	{
		if(m.isEmpty()) return null;
		return m.get(random(m.keySet()));
	}
	
	
	private Object random(Set s)
	{
		if(s.isEmpty()) return null;
		
		Object r = null;
		int n = random(s.size());
		Iterator it = s.iterator();
		for(int i=0;i<n;i++) r = it.next();
		return r;
	}
}
