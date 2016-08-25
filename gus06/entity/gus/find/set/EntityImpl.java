package gus06.entity.gus.find.set;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160804";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Set) return (Set) obj;
		if(obj instanceof List) return new HashSet((List) obj);
		
		if(obj instanceof Object[]) return toSet((Object[]) obj);
		if(obj instanceof int[]) return toSet((int[]) obj);
		if(obj instanceof short[]) return toSet((short[]) obj);
		if(obj instanceof long[]) return toSet((long[]) obj);
		if(obj instanceof double[]) return toSet((double[]) obj);
		if(obj instanceof float[]) return toSet((float[]) obj);
		if(obj instanceof boolean[]) return toSet((boolean[]) obj);
		if(obj instanceof char[]) return toSet((char[]) obj);
		
		return toSet(obj);
	}
	
	
	
	
	private Set toSet(Object o)
	{
		Set s = new HashSet();
		s.add(o);
		return s;
	}
	
	
	
	
	private Set toSet(Object[] oo)
	{
		Set s = new HashSet();
		for(Object o:oo) s.add(o);
		return s;
	}
	
	
	private Set toSet(int[] oo)
	{
		Set s = new HashSet();
		for(int o:oo) s.add(new Integer(o));
		return s;
	}
	
	private Set toSet(short[] oo)
	{
		Set s = new HashSet();
		for(short o:oo) s.add(new Short(o));
		return s;
	}
	
	private Set toSet(long[] oo)
	{
		Set s = new HashSet();
		for(long o:oo) s.add(new Long(o));
		return s;
	}
	
	private Set toSet(double[] oo)
	{
		Set s = new HashSet();
		for(double o:oo) s.add(new Double(o));
		return s;
	}
	
	private Set toSet(float[] oo)
	{
		Set s = new HashSet();
		for(float o:oo) s.add(new Float(o));
		return s;
	}
	
	private Set toSet(boolean[] oo)
	{
		Set s = new HashSet();
		for(boolean o:oo) s.add(new Boolean(o));
		return s;
	}
	
	private Set toSet(char[] oo)
	{
		Set s = new HashSet();
		for(char o:oo) s.add(""+o);
		return s;
	}
}
