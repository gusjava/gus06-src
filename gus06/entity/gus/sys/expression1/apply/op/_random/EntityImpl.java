package gus06.entity.gus.sys.expression1.apply.op._random;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return new Integer(random(toInt(obj)));
		if(obj instanceof Boolean) return new Boolean(Math.random()<0.5);
		if(obj instanceof List) return random((List) obj);
		if(obj instanceof Set) return random((Set) obj);
		if(obj instanceof Map) return random((Map) obj);
		if(obj instanceof Object[]) return random((Object[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	
	private int random(int n)
	{return (int) (Math.random()*n);}
	
	
	private Object random(List list)
	{return list.get(random(list.size()));}
	
	
	private Object random(Object[] array)
	{return array[random(array.length)];}
	
	
	private Object random(Map m)
	{return m.get(random(m.keySet()));}
	
	
	private Object random(Set s)
	{
		int n = random(s.size());
		Iterator it = s.iterator();
		for(int i=0;i<n;i++) it.next();
		return it.next();
	}
}
