package gus06.entity.gus.sys.expression1.apply.op._tolist;

import gus06.framework.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collection;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof List) return obj;
		if(obj instanceof Set) return new ArrayList((Set) obj);
		if(obj instanceof Collection) return new ArrayList((Collection) obj);
		if(obj instanceof Map) return new ArrayList(((Map) obj).values());
		
		if(obj instanceof Object[]) return toList((Object[]) obj);
		if(obj instanceof int[]) return toList((int[]) obj);
		if(obj instanceof double[]) return toList((double[]) obj);
		if(obj instanceof boolean[]) return toList((boolean[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private List toList(Object[] oo)
	{
		List l = new ArrayList();
		for(Object o:oo) l.add(o);
		return l;
	}
	
	
	private List toList(int[] oo)
	{
		List l = new ArrayList();
		for(int o:oo) l.add(new Integer(o));
		return l;
	}
	
	private List toList(double[] oo)
	{
		List l = new ArrayList();
		for(double o:oo) l.add(new Double(o));
		return l;
	}
	
	private List toList(boolean[] oo)
	{
		List l = new ArrayList();
		for(boolean o:oo) l.add(new Boolean(o));
		return l;
	}
}
