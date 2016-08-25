package gus06.entity.gus.find.intarray;

import gus06.framework.*;
import java.util.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160626";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof int[]) return obj;
		if(obj instanceof double[]) return handle((double[]) obj);
		if(obj instanceof long[]) return handle((long[]) obj);
		if(obj instanceof float[]) return handle((float[]) obj);
		
		if(obj instanceof Set) return handle((Set) obj);
		if(obj instanceof List) return handle((List) obj);
		if(obj instanceof Object[]) return handle((Object[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private int[] handle(double[] t)
	{
		int[] n = new int[t.length];
		for(int i=0;i<t.length;i++) n[i] = (int) t[i];
		return n;
	}
	
	private int[] handle(long[] t)
	{
		int[] n = new int[t.length];
		for(int i=0;i<t.length;i++) n[i] = (int) t[i];
		return n;
	}
	
	private int[] handle(float[] t)
	{
		int[] n = new int[t.length];
		for(int i=0;i<t.length;i++) n[i] = (int) t[i];
		return n;
	}
	
	private int[] handle(Object[] t) throws Exception
	{
		int[] n = new int[t.length];
		for(int i=0;i<t.length;i++) n[i] = toInt(t[i]);
		return n;
	}
	
	private int[] handle(List list) throws Exception
	{
		int[] n = new int[list.size()];
		for(int i=0;i<list.size();i++) n[i] = toInt(list.get(i));
		return n;
	}
	
	private int[] handle(Set set) throws Exception
	{
		return handle(new ArrayList(set));
	}
	
	
	
	
	private int toInt(Object obj) throws Exception
	{
		if(obj instanceof String) return Integer.parseInt((String) obj);
		if(obj instanceof Number) return ((Number) obj).intValue();
		
		throw new Exception("Invalid data type for int conversion: "+obj.getClass().getName());
	}
	
}
