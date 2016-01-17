package gus06.entity.gus.sys.expression1.apply.op._max;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof int[]) return max((int[]) obj);
		if(obj instanceof double[]) return max((double[]) obj);
		if(obj instanceof float[]) return max((float[]) obj);
		if(obj instanceof long[]) return max((long[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Integer max(int[] array)
	{
		int max = Integer.MIN_VALUE;
		for(int n:array) if(n>max) max = n;
		return new Integer(max);
	}
	
	private Double max(double[] array)
	{
		double max = Double.MIN_VALUE;
		for(double n:array) if(n>max) max = n;
		return new Double(max);
	}
	
	private Float max(float[] array)
	{
		float max = Float.MIN_VALUE;
		for(float n:array) if(n>max) max = n;
		return new Float(max);
	}
	
	private Long max(long[] array)
	{
		long max = Long.MIN_VALUE;
		for(long n:array) if(n>max) max = n;
		return new Long(max);
	}
}
