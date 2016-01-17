package gus06.entity.gus.sys.parser3.resolver1.op.seq.product;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	private Service product_int;
	private Service product_double;
	
	private Service toArray_int;
	private Service toArray_double;


	public EntityImpl() throws Exception
	{
		product_int = Outside.service(this,"gus.math.tabint.product");
		product_double = Outside.service(this,"gus.math.tabdouble.product");
		
		toArray_int = Outside.service(this,"gus.convert.objarraytointarray.strict");
		toArray_double = Outside.service(this,"gus.convert.objarraytodoublearray.strict");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List cut = (List) o[0];
		T t = (T) o[1];
		
		int nb = cut.size();
		Object[] oo = new Object[nb];
		for(int i=0;i<nb;i++) oo[i] = t.t(cut.get(i));
		
		
		int[] nn = (int[]) toArray_int.t(oo);
		if(nn!=null) return product_int.t(nn);
		
		double[] dd = (double[]) toArray_double.t(oo);
		if(dd!=null) return product_double.t(dd);
		
		
		Object[] objByScalar = (Object[]) findByObjScalar(oo);
		if(objByScalar!=null)
		{
			int scalar = ((Integer) objByScalar[0]).intValue();
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
		}
		
		throw new Exception("Invalid product operation");
	}
	
	
	
	
	private Object[] findByObjScalar(Object[] oo)
	{
		int factor = 1;
		Object element = null;
		
		for(Object o:oo)
		{
			if(o instanceof Integer) factor *= ((Integer)o).intValue();
			else if(element==null) element = o;
			else return null;
		}
		
		if(element==null) return null;
		return new Object[]{new Integer(factor),element};
	}
	
	
	
	
	private String multString(int k, String s)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<k;i++) b.append(s);
		return b.toString();
	}
	
	private List multList(int k, List l)
	{
		List ll = new ArrayList();
		for(int i=0;i<k;i++) ll.addAll(l);
		return ll;
	}
	
	
	private E multE(int k, E e)
	{return new E0(k,e);}
	
	private P multP(int k, P p)
	{return new P0(k,p);}
	
	private H multH(int k, H h)
	{return new H0(k,h);}
	
	
	private int[] multIntArray(int k, int[] v)
	{
		int[] kv = new int[v.length];
		for(int i=0;i<v.length;i++) kv[i] = k * v[i];
		return kv;
	}
	
	private double[] multDoubleArray(int k, double[] v)
	{
		double[] kv = new double[v.length];
		for(int i=0;i<v.length;i++) kv[i] = k * v[i];
		return kv;
	}
	
	
	
	private class E0 implements E
	{
		private int k;
		private E e;
		public E0(int k, E e)
		{this.k = k;this.e = e;}
		
		public void e() throws Exception
		{for(int i=0;i<k;i++) e.e();}
	}
	
	private class P0 implements P
	{
		private int k;
		private P p;
		public P0(int k, P p)
		{this.k = k;this.p = p;}
		
		public void p(Object obj) throws Exception
		{for(int i=0;i<k;i++) p.p(obj);}
	}
	
	private class H0 implements H
	{
		private int k;
		private H h;
		public H0(int k, H h)
		{this.k = k;this.h = h;}
		
		public double h(double v) throws Exception
		{return h.h(v) * k;}
	}
}
