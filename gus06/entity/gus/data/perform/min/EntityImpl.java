package gus06.entity.gus.data.perform.min;

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
	
	private Service min_int;
	private Service min_double;
	private Service min_float;
	private Service min_long;
	private Service min_h;
	private Service min_list;
	
	
	public EntityImpl() throws Exception
	{
		toArray_int = Outside.service(this,"gus.convert.objarraytointarray.strict");
		toArray_double = Outside.service(this,"gus.convert.objarraytodoublearray.strict");
		toArray_float = Outside.service(this,"gus.convert.objarraytofloatarray.strict");
		toArray_long = Outside.service(this,"gus.convert.objarraytolongarray.strict");
		toArray_h = Outside.service(this,"gus.convert.objarraytoharray.strict");
		
		min_int = Outside.service(this,"gus.math.tabint.min");
		min_double = Outside.service(this,"gus.math.tabdouble.min");
		min_float = Outside.service(this,"gus.math.tabfloat.min");
		min_long = Outside.service(this,"gus.math.tablong.min");
		min_h = Outside.service(this,"gus.feature.op.function.min");
		min_list = Outside.service(this,"gus.list.min");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Number) return new HMin(toDouble((Number) obj));
		
		if(obj instanceof int[]) return min_int.t(obj);
		if(obj instanceof double[]) return min_double.t(obj);
		if(obj instanceof float[]) return min_float.t(obj);
		if(obj instanceof long[]) return min_long.t(obj);
		if(obj instanceof H[]) return min_h.t(obj);
		
		if(obj instanceof Object[]) return arrayMin((Object[]) obj);
		if(obj instanceof List) return min_list.t(obj);
		if(obj instanceof Set) return min_list.t(new ArrayList((Set) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object arrayMin(Object[] oo) throws Exception
	{
		int[] nn = (int[]) toArray_int.t(oo);
		if(nn!=null) return min_int.t(nn);
		
		double[] dd = (double[]) toArray_double.t(oo);
		if(dd!=null) return min_double.t(dd);
		
		float[] xx = (float[]) toArray_float.t(oo);
		if(xx!=null) return min_float.t(xx);
		
		long[] yy = (long[]) toArray_long.t(oo);
		if(yy!=null) return min_long.t(yy);
		
		H[] hh = (H[]) toArray_h.t(oo);
		if(hh!=null) return min_h.t(hh);
		
		throw new Exception("Invalid list content for min operation");
	}
	
	
	private double toDouble(Number n)
	{return n.doubleValue();}
	
	private class HMin implements H
	{
		private double l;
		public HMin(double l) {this.l = l;}
		
		public double h(double v) throws Exception
		{return Math.min(v,l);}
	}
}
