package gus06.entity.gus.data.perform.opp;

import gus06.framework.*;
import java.util.Set;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151126";}


	private Service oppFunction;
	private Service oppSet;
	private Service oppList;
	private Service oppMap;
	
	public EntityImpl() throws Exception
	{
		oppFunction = Outside.service(this,"gus.feature.op.function.opp");
		oppSet = Outside.service(this,"gus.sys.opposite1.set.perform");
		oppList = Outside.service(this,"gus.sys.opposite1.list.perform");
		oppMap = Outside.service(this,"gus.map.opp.map");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Set) return oppSet.t(obj);
		if(obj instanceof List) return oppList.t(obj);
		if(obj instanceof Map) return oppMap.t(obj);
		if(obj instanceof H) return oppFunction.t(obj);
		
		if(obj instanceof Integer) return new Integer(-1*toInt(obj));
		if(obj instanceof Double) return new Double(-1*toDouble(obj));
		if(obj instanceof Float) return new Float(-1*toFloat(obj));
		if(obj instanceof Long) return new Long(-1*toLong(obj));
		
		if(obj instanceof int[])
		{
			int[] n = (int[]) obj;
			int[] n1 = new int[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		if(obj instanceof double[])
		{
			double[] n = (double[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		if(obj instanceof float[])
		{
			float[] n = (float[]) obj;
			float[] n1 = new float[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		if(obj instanceof long[])
		{
			long[] n = (long[]) obj;
			long[] n1 = new long[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
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
