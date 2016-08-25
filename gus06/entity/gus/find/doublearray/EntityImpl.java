package gus06.entity.gus.find.doublearray;

import gus06.framework.*;
import java.util.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150516";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof double[]) return obj;
		if(obj instanceof int[]) return handle((int[]) obj);
		if(obj instanceof long[]) return handle((long[]) obj);
		if(obj instanceof float[]) return handle((float[]) obj);
		
		if(obj instanceof Set) return handle((Set) obj);
		if(obj instanceof List) return handle((List) obj);
		if(obj instanceof Object[]) return handle((Object[]) obj);
		
		if(obj instanceof double[][])
		{
			double[][] d = (double[][]) obj;
			if(d.length==1) return d[0];
			if(d.length>1 && d[0].length==1)
			{
				int l = d.length;
				double[] r = new double[l];
				for(int i=0;i<l;i++) r[i] = d[i][0];
				return r;
			}
			throw new Exception("Invalid array length: "+d.length);
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private double[] handle(int[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = (double) t[i];
		return n;
	}
	
	private double[] handle(long[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = (double) t[i];
		return n;
	}
	
	private double[] handle(float[] t)
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = (double) t[i];
		return n;
	}
	
	private double[] handle(Object[] t) throws Exception
	{
		double[] n = new double[t.length];
		for(int i=0;i<t.length;i++) n[i] = toDouble(t[i]);
		return n;
	}
	
	private double[] handle(List list) throws Exception
	{
		double[] n = new double[list.size()];
		for(int i=0;i<list.size();i++) n[i] = toDouble(list.get(i));
		return n;
	}
	
	private double[] handle(Set set) throws Exception
	{
		return handle(new ArrayList(set));
	}
	
	
	
	
	private double toDouble(Object obj) throws Exception
	{
		if(obj instanceof String) return Double.parseDouble((String) obj);
		if(obj instanceof Number) return ((Number) obj).doubleValue();
		
		throw new Exception("Invalid data type for double conversion: "+obj.getClass().getName());
	}
	
}
