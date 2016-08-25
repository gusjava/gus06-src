package gus06.entity.gus.sys.parser3.resolver1.op.seq.product.motley;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}


	
	
	private Service listByScalar;

	public EntityImpl() throws Exception
	{
		listByScalar = Outside.service(this,"gus.sys.opposite1.list.byscalar");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		Object[] objByScalar = (Object[]) findByObjScalar(oo);
		if(objByScalar==null) throw new Exception("Invalid product operation");
		
		
		Double scalar = (Double) objByScalar[0];
		Object element = objByScalar[1];
		
		
		if(element instanceof String)
		return multString(scalar,(String) element);
		
		if(element instanceof List)
		return multList(scalar,(List) element);
		
		if(element instanceof E)
		return multE(scalar,(E) element);
		
		if(element instanceof P)
		return multP(scalar,(P) element);
		
		if(element instanceof H)
		return multH(scalar,(H) element);
		
		if(element instanceof int[])
		return multIntArray(scalar,(int[]) element);
		
		if(element instanceof double[])
		return multDoubleArray(scalar,(double[]) element);
		
		throw new Exception("Invalid product operation");
		
	}
	
	
	
	
	private Object[] findByObjScalar(Object[] oo)
	{
		double factor = 1;
		Object element = null;
		
		for(Object o:oo)
		{
			if(o instanceof Number) factor *= ((Number)o).doubleValue();
			else if(element==null) element = o;
			else return null;
		}
		
		if(element==null) return null;
		return new Object[]{new Double(factor),element};
	}
	
	
	
	
	private String multString(Double k, String s)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<k.intValue();i++) b.append(s);
		return b.toString();
	}
	
	private List multList(Double k, List l) throws Exception
	{
		return (List) listByScalar.t(new Object[]{l,new Integer(k.intValue())});
	}
	
	
	private E multE(Double k, E e)
	{return new E0(k.intValue(),e);}
	
	private P multP(Double k, P p)
	{return new P0(k.intValue(),p);}
	
	private H multH(Double k, H h)
	{return new H0(k.doubleValue(),h);}
	
	
	private int[] multIntArray(Double k, int[] v)
	{
		int[] kv = new int[v.length];
		for(int i=0;i<v.length;i++) kv[i] = k.intValue() * v[i];
		return kv;
	}
	
	
	
	private double[] multDoubleArray(Double k, double[] v)
	{
		double[] kv = new double[v.length];
		for(int i=0;i<v.length;i++) kv[i] = k.doubleValue() * v[i];
		return kv;
	}
	
	
	
	private class E0 implements E
	{
		private int k;
		private E e;
		
		public E0(int k, E e)
		{
			this.k = k;
			this.e = e;
		}
		
		public void e() throws Exception
		{for(int i=0;i<k;i++) e.e();}
	}
	
	
	
	private class P0 implements P
	{
		private int k;
		private P p;
		
		public P0(int k, P p)
		{
			this.k = k;
			this.p = p;
		}
		
		public void p(Object obj) throws Exception
		{for(int i=0;i<k;i++) p.p(obj);}
	}
	
	
	
	private class H0 implements H
	{
		private double k;
		private H h;
		
		public H0(double k, H h)
		{
			this.k = k;
			this.h = h;
		}
		
		public double h(double v) throws Exception
		{return h.h(v) * k;}
	}
}
