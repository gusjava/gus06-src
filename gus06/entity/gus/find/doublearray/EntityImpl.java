package gus06.entity.gus.find.doublearray;

import gus06.framework.*;
import java.util.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150516";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof double[]) return obj;
		if(obj instanceof int[]) return intArrToArray((int[]) obj);
		if(obj instanceof long[]) return intArrToArray((long[]) obj);
		if(obj instanceof float[]) return intArrToArray((float[]) obj);
		if(obj instanceof String[]) return intArrToArray((String[]) obj);
		if(obj instanceof List) return listToArray((List) obj);
		if(obj instanceof Set) return setToArray((Set) obj);
		if(obj instanceof Map) return mapToArray((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private double[] intArrToArray(int[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = (double) t[i];
		return n;
	}
	
	private double[] intArrToArray(long[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = (double) t[i];
		return n;
	}
	
	private double[] intArrToArray(float[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = (double) t[i];
		return n;
	}
	
	private double[] intArrToArray(String[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = Double.parseDouble(t[i]);
		return n;
	}
	
	
	
	
	
	private double[] listToArray(List list) throws Exception
	{
		double[] n = new double[list.size()];
		for(int i=0;i<list.size();i++) n[i] = toDouble(list.get(i));
		return n;
	}
	
	private double[] setToArray(Set set) throws Exception
	{
		ArrayList list = new ArrayList(set);
		Collections.sort(list);
		return listToArray(list);
	}
	
	private double[] mapToArray(Map map) throws Exception
	{
		return setToArray(map.keySet());
	}
	
	
	private double toDouble(Object obj) throws Exception
	{
		if(obj instanceof String) return Double.parseDouble((String) obj);
		if(obj instanceof Double) return ((Double) obj).doubleValue();
		
		throw new Exception("Invalid data type for double conversion: "+obj.getClass().getName());
	}
	
}
