package gus06.entity.gus.data.perform.sum;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


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
	
	
	public EntityImpl() throws Exception
	{
		sum_bool = Outside.service(this,"gus.math.tabboolean.and");
		sum_int = Outside.service(this,"gus.math.tabint.sum");
		sum_double = Outside.service(this,"gus.math.tabdouble.sum");
		sum_float = Outside.service(this,"gus.math.tabfloat.sum");
		sum_long = Outside.service(this,"gus.math.tablong.sum");
		
		sum_string = Outside.service(this,"gus.string.stringarray.tostring");
		sum_list = Outside.service(this,"gus.list.listarray.tolist");
		sum_set = Outside.service(this,"gus.set.setarray.toset");
		sum_map = Outside.service(this,"gus.map.maparray.tomap");
		
		sum_e = Outside.service(this,"gus.feature.op.sum.e");
		sum_h = Outside.service(this,"gus.feature.op.sum.h");
		sum_p = Outside.service(this,"gus.feature.op.sum.p");
		sum_f = Outside.service(this,"gus.feature.op.filter.and");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof boolean[]) return sum_bool.t(obj);
		if(obj instanceof int[]) return sum_int.t(obj);
		if(obj instanceof double[]) return sum_double.t(obj);
		if(obj instanceof float[]) return sum_float.t(obj);
		if(obj instanceof long[]) return sum_long.t(obj);
		
		if(obj instanceof String[]) return sum_string.t(obj);
		if(obj instanceof List[]) return sum_list.t(obj);
		if(obj instanceof Set[]) return sum_set.t(obj);
		if(obj instanceof Map[]) return sum_map.t(obj);
		
		if(obj instanceof E[]) return sum_e.t(obj);
		if(obj instanceof H[]) return sum_h.t(obj);
		if(obj instanceof P[]) return sum_p.t(obj);
		if(obj instanceof F[]) return sum_f.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
