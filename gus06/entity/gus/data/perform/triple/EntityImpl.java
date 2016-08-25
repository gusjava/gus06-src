package gus06.entity.gus.data.perform.triple;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	private Service tripleFunction;
	
	public EntityImpl() throws Exception
	{
		tripleFunction = Outside.service(this,"gus.feature.op.function.double1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof E) return new E0((E) obj);
		if(obj instanceof H) return tripleFunction.t(obj);
		if(obj instanceof List) return tripleList((List) obj);
		if(obj instanceof String) return tripleString((String) obj);
		
		if(obj instanceof Integer) return new Integer(toInt(obj)*3);
		if(obj instanceof Double) return new Double(toDouble(obj)*3);
		if(obj instanceof Float) return new Float(toFloat(obj)*3);
		if(obj instanceof Long) return new Long(toLong(obj)*3);
		
		if(obj instanceof int[])
		{
			int[] n = (int[]) obj;
			int[] n1 = new int[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*3;
			return n1;
		}
		if(obj instanceof double[])
		{
			double[] n = (double[]) obj;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*3;
			return n1;
		}
		if(obj instanceof float[])
		{
			float[] n = (float[]) obj;
			float[] n1 = new float[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*3;
			return n1;
		}
		if(obj instanceof long[])
		{
			long[] n = (long[]) obj;
			long[] n1 = new long[n.length];
			for(int i=0;i<n.length;i++) n1[i] = n[i]*3;
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
	
	
	
	
	private String tripleString(String s)
	{
		return s+s+s;
	}
	
	private List tripleList(List l)
	{
		List l1 = new ArrayList();
		l1.addAll(l);
		l1.addAll(l);
		l1.addAll(l);
		return l1;
	}
	
	
	private class E0 implements E
	{
		private E e;
		public E0(E e) {this.e = e;}
		
		public void e() throws Exception
		{e.e();e.e();e.e();}
	}
}
