package gus06.entity.gus.sys.parser3.resolver1.op.binary.perform;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}


	private Service wrap_pobj;

	public EntityImpl() throws Exception
	{
		wrap_pobj = Outside.service(this,"gus.feature.wrap.pobj.e");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=2) throw new Exception("Invalid split for equals operation: "+cut.length);
		
		List l1 = cut[0];
		List l2 = cut[1];
		
		Object o1 = t.t(l1);
		Object o2 = t.t(l2);
		
		if(o1 instanceof T) return ((T) o1).t(o2);
		if(o1 instanceof R) return ((R) o1).r((String) o2);
		if(o1 instanceof F) return new Boolean(((F) o1).f(o2));
		if(o1 instanceof H) return new Double(((H) o1).h(toDouble(o2)));
		if(o1 instanceof P) return wrap_pobj.t(new Object[]{o1,o2});
		
		throw new Exception("Invalid data type: "+o1.getClass().getName());
	}
	
	
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
}
