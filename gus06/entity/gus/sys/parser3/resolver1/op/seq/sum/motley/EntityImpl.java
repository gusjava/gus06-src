package gus06.entity.gus.sys.parser3.resolver1.op.seq.sum.motley;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151112";}


	private Service motley_set;
	private Service motley_list;
	private Service motley_h;
	private Service motley_string;
	
	public EntityImpl() throws Exception
	{
		motley_set = Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum.motley.set");
		motley_list = Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum.motley.list");
		motley_h = Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum.motley.h");
		motley_string = Outside.service(this,"gus.sys.parser3.resolver1.op.seq.sum.motley.string");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		if(hasSet(oo)) return motley_set.t(oo);
		if(hasList(oo)) return motley_list.t(oo);
		if(hasH(oo)) return motley_h.t(oo);
		
		return motley_string.t(oo);
	}
	
	
	
	
	private boolean hasSet(Object[] oo)
	{
		for(Object o:oo) if(o instanceof Set) return true;
		return false;
	}
	
	private boolean hasList(Object[] oo)
	{
		for(Object o:oo) if(o instanceof List) return true;
		return false;
	}
	
	private boolean hasH(Object[] oo)
	{
		for(Object o:oo) if(o instanceof H) return true;
		return false;
	}
}
