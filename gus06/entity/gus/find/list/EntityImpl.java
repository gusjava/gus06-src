package gus06.entity.gus.find.list;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150530";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List) return (List) obj;
		if(obj instanceof Set) return new ArrayList((Set) obj);
		
		if(obj instanceof Object[]) return toList((Object[]) obj);
		if(obj instanceof int[]) return toList((int[]) obj);
		if(obj instanceof short[]) return toList((short[]) obj);
		if(obj instanceof long[]) return toList((long[]) obj);
		if(obj instanceof double[]) return toList((double[]) obj);
		if(obj instanceof float[]) return toList((float[]) obj);
		if(obj instanceof boolean[]) return toList((boolean[]) obj);
		if(obj instanceof char[]) return toList((char[]) obj);
		
		return toList(obj);
	}
	
	
	
	
	private List toList(Object o)
	{
		List list = new ArrayList();
		list.add(o);
		return list;
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
	
	private List toList(short[] oo)
	{
		List l = new ArrayList();
		for(short o:oo) l.add(new Short(o));
		return l;
	}
	
	private List toList(long[] oo)
	{
		List l = new ArrayList();
		for(long o:oo) l.add(new Long(o));
		return l;
	}
	
	private List toList(double[] oo)
	{
		List l = new ArrayList();
		for(double o:oo) l.add(new Double(o));
		return l;
	}
	
	private List toList(float[] oo)
	{
		List l = new ArrayList();
		for(float o:oo) l.add(new Float(o));
		return l;
	}
	
	private List toList(boolean[] oo)
	{
		List l = new ArrayList();
		for(boolean o:oo) l.add(new Boolean(o));
		return l;
	}
	
	private List toList(char[] oo)
	{
		List l = new ArrayList();
		for(char o:oo) l.add(""+o);
		return l;
	}
}
