package gus06.entity.gus.data.perform.half;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	private Service halfFunction;
	
	public EntityImpl() throws Exception
	{
		halfFunction = Outside.service(this,"gus.feature.op.function.half");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof H) return halfFunction.t(obj);
		
		if(obj instanceof Integer) return new Double(toInt(obj)*0.5);
		if(obj instanceof Double) return new Double(toDouble(obj)*0.5);
		if(obj instanceof Float) return new Double(toFloat(obj)*0.5);
		if(obj instanceof Long) return new Double(toLong(obj)*0.5);
		
		if(obj instanceof int[])
		{
			int[] n = (int[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*0.5;
			return n1;
		}
		if(obj instanceof double[])
		{
			double[] n = (double[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*0.5;
			return n1;
		}
		if(obj instanceof float[])
		{
			float[] n = (float[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*0.5;
			return n1;
		}
		if(obj instanceof long[])
		{
			long[] n = (long[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*0.5;
			return n1;
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private int toInt(Object obj)
	{return ((Integer) obj).intValue();}
	
	private double toDouble(Object obj)
	{return ((Double) obj).doubleValue();}
	
	private float toFloat(Object obj)
	{return ((Float) obj).floatValue();}
	
	private long toLong(Object obj)
	{return ((Long) obj).longValue();}
}
