package gus06.entity.gus.feature.op.pipenext.p;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161212";}


	private Service pg;
	private Service pe;
	
	public EntityImpl() throws Exception
	{
		pg = Outside.service(this,"gus.feature.wrap.pg.t");
		pe = Outside.service(this,"gus.feature.wrap.pe.p");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		P p = (P) o[0];
		
		if(o[1] instanceof G) return pg.t(o);
		if(o[1] instanceof E) return pe.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
}
