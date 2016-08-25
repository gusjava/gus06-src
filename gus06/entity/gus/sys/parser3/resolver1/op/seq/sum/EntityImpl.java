package gus06.entity.gus.sys.parser3.resolver1.op.seq.sum;

import gus06.framework.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import javax.swing.Icon;
import java.io.PrintStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151028";}


	
	private Service toArray_bool;
	private Service toArray_int;
	private Service toArray_double;
	private Service toArray_float;
	private Service toArray_long;
	
	private Service toArray_string;
	private Service toArray_list;
	private Service toArray_set;
	private Service toArray_map;
	
	private Service toArray_e;
	private Service toArray_h;
	private Service toArray_p;
	private Service toArray_f;
	private Service toArray_t;
	
	private Service toArray_icon;
	private Service toArray_printstream;
	
	
	private Service sum_bool;
	private Service sum_int;
	private Service sum_double;
	private Service sum_float;
	private Service sum_long;
	
	private Service sum_string;
	private Service sum_list;
	private Service sum_set;
	private Service sum_map;
	
	private Service sum_e;
	private Service sum_h;
	private Service sum_p;
	private Service sum_f;
	private Service sum_t;
	
	private Service sum_icon;
	private Service sum_printstream;
	
	
	private Service isType_intarray;
	private Service isType_longarray;
	private Service isType_doublearray;
	private Service isType_bytearray;
	
	private Service sum_intarray;
	private Service sum_longarray;
	private Service sum_doublearray;
	private Service sum_bytearray;
	
	private Service sum_motley;
	
	
	private T sumT = new T(){
		public Object t(Object obj) throws Exception
		{return perform((Object[]) obj);}
	};
	



	public EntityImpl() throws Exception
	{
		toArray_bool = Outside.service(this,"gus.convert.objarraytoboolarray.strict");
		toArray_int = Outside.service(this,"gus.convert.objarraytointarray.strict");
		toArray_double = Outside.service(this,"gus.convert.objarraytodoublearray.strict");
		toArray_float = Outside.service(this,"gus.convert.objarraytofloatarray.strict");
		toArray_long = Outside.service(this,"gus.convert.objarraytolongarray.strict");
		
		toArray_string = Outside.service(this,"gus.convert.objarraytostringarray.strict");
		toArray_list = Outside.service(this,"gus.convert.objarraytolistarray.strict");
		toArray_set = Outside.service(this,"gus.convert.objarraytosetarray.strict");
		toArray_map = Outside.service(this,"gus.convert.objarraytomaparray.strict");
		
		toArray_e = Outside.service(this,"gus.convert.objarraytoearray.strict");
		toArray_h = Outside.service(this,"gus.convert.objarraytoharray.strict");
		toArray_p = Outside.service(this,"gus.convert.objarraytoparray.strict");
		toArray_f = Outside.service(this,"gus.convert.objarraytofarray.strict");
		toArray_t = Outside.service(this,"gus.convert.objarraytotarray.strict");
		
		toArray_icon = Outside.service(this,"gus.convert.objarraytoiconarray.strict");
		toArray_printstream = Outside.service(this,"gus.convert.objarraytoprintstreamarray.strict");
		
		
		sum_bool = Outside.service(this,"gus.math.tabboolean.and");
		sum_int = Outside.service(this,"gus.math.tabint.sum");
		sum_double = Outside.service(this,"gus.math.tabdouble.sum");
		sum_float = Outside.service(this,"gus.math.tabfloat.sum");
		sum_long = Outside.service(this,"gus.math.tablong.sum");
		
		sum_string = Outside.service(this,"gus.string.stringarray.tostring");
		sum_list = Outside.service(this,"gus.sys.opposite1.list.sum");
		sum_set = Outside.service(this,"gus.sys.opposite1.set.sum");
		sum_map = Outside.service(this,"gus.map.maparray.tomap");
		
		sum_e = Outside.service(this,"gus.feature.op.sum.e");
		sum_h = Outside.service(this,"gus.feature.op.sum.h");
		sum_p = Outside.service(this,"gus.feature.op.sum.p");
		sum_f = Outside.service(this,"gus.feature.op.filter.and");
		sum_t = Outside.service(this,"gus.feature.op.transform.sum");
		
		sum_icon = Outside.service(this,"gus.convert.iconstoicon");
		sum_printstream = Outside.service(this,"gus.io.printstream.sum");
		
		
		isType_intarray = Outside.service(this,"gus.data.array.istype.intarray");
		isType_longarray = Outside.service(this,"gus.data.array.istype.longarray");
		isType_doublearray = Outside.service(this,"gus.data.array.istype.intdoublearray");
		isType_bytearray = Outside.service(this,"gus.data.array.istype.bytearray");
		
		sum_intarray = Outside.service(this,"gus.math.vectors.sum.intarray");
		sum_longarray = Outside.service(this,"gus.math.vectors.sum.longarray");
		sum_doublearray = Outside.service(this,"gus.math.vectors.sum.doublearray");
		sum_bytearray = Outside.service(this,"gus.data.array.sum.bytearray");
		
		sum_motley = Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum.motley");
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
		
		return perform(oo);
	}
	
	
	
	
	private Object perform(Object[] oo) throws Exception
	{
		boolean[] bb = (boolean[]) toArray_bool.t(oo);
		if(bb!=null) return sum_bool.t(bb);
		
		int[] nn = (int[]) toArray_int.t(oo);
		if(nn!=null) return sum_int.t(nn);
		
		double[] dd = (double[]) toArray_double.t(oo);
		if(dd!=null) return sum_double.t(dd);
		
		float[] xx = (float[]) toArray_float.t(oo);
		if(xx!=null) return sum_float.t(xx);
		
		long[] yy = (long[]) toArray_long.t(oo);
		if(yy!=null) return sum_long.t(yy);
		
		
		
		String[] aa = (String[]) toArray_string.t(oo);
		if(aa!=null) return sum_string.t(aa);
		
		List[] ll = (List[]) toArray_list.t(oo);
		if(ll!=null) return sum_list.t(ll);
		
		Set[] ss = (Set[]) toArray_set.t(oo);
		if(ss!=null) return sum_set.t(ss);
		
		Map[] mm = (Map[]) toArray_map.t(oo);
		if(mm!=null) return sum_map.t(mm);
		
		
		
		E[] ee = (E[]) toArray_e.t(oo);
		if(ee!=null) return sum_e.t(ee);
		
		H[] hh = (H[]) toArray_h.t(oo);
		if(hh!=null) return sum_h.t(hh);
		
		P[] pp = (P[]) toArray_p.t(oo);
		if(pp!=null) return sum_p.t(pp);
		
		F[] ff = (F[]) toArray_f.t(oo);
		if(ff!=null) return sum_f.t(ff);
		
		T[] tt = (T[]) toArray_t.t(oo);
		if(tt!=null) return sum_t.t(new Object[]{tt,sumT});
		
		
		
		Icon[] ii = (Icon[]) toArray_icon.t(oo);
		if(ii!=null) return sum_icon.t(ii);
		
		PrintStream[] kk = (PrintStream[]) toArray_printstream.t(oo);
		if(kk!=null) return sum_printstream.t(kk);
		
		
		
		if(isType_intarray.f(oo)) return sum_intarray.t(oo);
		if(isType_longarray.f(oo)) return sum_longarray.t(oo);
		if(isType_doublearray.f(oo)) return sum_doublearray.t(oo);
		if(isType_bytearray.f(oo)) return sum_bytearray.t(oo);
		
		
		return sum_motley.t(oo);
	}
}
