package gus06.entity.gus.sys.expression1.apply.op._h_abs;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}


	private Service function;
	
	public EntityImpl() throws Exception
	{
		function = Outside.service(this,"gus.math.function.h.abs");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return function;
	}
}
