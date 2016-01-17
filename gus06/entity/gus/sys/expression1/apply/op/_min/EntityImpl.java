package gus06.entity.gus.sys.expression1.apply.op._min;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof int[]) return min((int[]) obj);
		if(obj instanceof double[]) return min((double[]) obj);
		if(obj instanceof float[]) return min((float[]) obj);
		if(obj instanceof long[]) return min((long[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Integer min(int[] array)
	{
		int min = Integer.MAX_VALUE;
		for(int n:array) if(n<min) min = n;
		return new Integer(min);
	}
	
	private Double min(double[] array)
	{
		double min = Double.MAX_VALUE;
		for(double n:array) if(n<min) min = n;
		return new Double(min);
	}
	
	private Float min(float[] array)
	{
		float min = Float.MAX_VALUE;
		for(float n:array) if(n<min) min = n;
		return new Float(min);
	}
	
	private Long min(long[] array)
	{
		long min = Long.MAX_VALUE;
		for(long n:array) if(n<min) min = n;
		return new Long(min);
	}
}
