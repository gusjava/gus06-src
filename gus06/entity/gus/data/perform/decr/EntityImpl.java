package gus06.entity.gus.data.perform.decr;

import gus06.framework.*;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	private Service decrFunction;
	
	public EntityImpl() throws Exception
	{
		decrFunction = Outside.service(this,"gus.feature.op.function.decr");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof H) return decrFunction.t(obj);
		
		if(obj instanceof Integer) return new Integer(toInt(obj)-1);
		if(obj instanceof Double) return new Double(toDouble(obj)-1);
		if(obj instanceof Float) return new Float(toFloat(obj)-1);
		if(obj instanceof Long) return new Long(toLong(obj)-1);
		
		if(obj instanceof int[])
		{
			int[] n = (int[]) obj;
			int[] n1 = new int[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]-1;
			return n1;
		}
		if(obj instanceof double[])
		{
			double[] n = (double[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]-1;
			return n1;
		}
		if(obj instanceof float[])
		{
			float[] n = (float[]) obj;
			float[] n1 = new float[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]-1;
			return n1;
		}
		if(obj instanceof long[])
		{
			long[] n = (long[]) obj;
			long[] n1 = new long[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]-1;
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
