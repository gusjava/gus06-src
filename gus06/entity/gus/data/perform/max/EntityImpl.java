package gus06.entity.gus.data.perform.max;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160624";}


	private Service toArray_int;
	private Service toArray_double;
	private Service toArray_float;
	private Service toArray_long;
	private Service toArray_h;
	
	private Service max_int;
	private Service max_double;
	private Service max_float;
	private Service max_long;
	private Service max_h;
	private Service max_list;
	
	
	public EntityImpl() throws Exception
	{
		toArray_int = Outside.service(this,"gus.convert.objarraytointarray.strict");
		toArray_double = Outside.service(this,"gus.convert.objarraytodoublearray.strict");
		toArray_float = Outside.service(this,"gus.convert.objarraytofloatarray.strict");
		toArray_long = Outside.service(this,"gus.convert.objarraytolongarray.strict");
		toArray_h = Outside.service(this,"gus.convert.objarraytoharray.strict");
		
		max_int = Outside.service(this,"gus.math.tabint.max");
		max_double = Outside.service(this,"gus.math.tabdouble.max");
		max_float = Outside.service(this,"gus.math.tabfloat.max");
		max_long = Outside.service(this,"gus.math.tablong.max");
		max_h = Outside.service(this,"gus.feature.op.function.max");
		max_list = Outside.service(this,"gus.list.max");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Number) return new HMax(toDouble((Number) obj));
		
		if(obj instanceof int[]) return max_int.t(obj);
		if(obj instanceof double[]) return max_double.t(obj);
		if(obj instanceof float[]) return max_float.t(obj);
		if(obj instanceof long[]) return max_long.t(obj);
		if(obj instanceof H[]) return max_h.t(obj);
		
		if(obj instanceof Object[]) return arrayMax((Object[]) obj);
		if(obj instanceof List) return max_list.t(obj);
		if(obj instanceof Set) return max_list.t(new ArrayList((Set) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object arrayMax(Object[] oo) throws Exception
	{
		int[] nn = (int[]) toArray_int.t(oo);
		if(nn!=null) return max_int.t(nn);
		
		double[] dd = (double[]) toArray_double.t(oo);
		if(dd!=null) return max_double.t(dd);
		
		float[] xx = (float[]) toArray_float.t(oo);
		if(xx!=null) return max_float.t(xx);
		
		long[] yy = (long[]) toArray_long.t(oo);
		if(yy!=null) return max_long.t(yy);
		
		H[] hh = (H[]) toArray_h.t(oo);
		if(hh!=null) return max_h.t(hh);
		
		throw new Exception("Invalid list content for max operation");
	}
	
	
	private double toDouble(Number n)
	{return n.doubleValue();}
	
	private class HMax implements H
	{
		private double l;
		public HMax(double l) {this.l = l;}
		
		public double h(double v) throws Exception
		{return Math.max(v,l);}
	}
}
