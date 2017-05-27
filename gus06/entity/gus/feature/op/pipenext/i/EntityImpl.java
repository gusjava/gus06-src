package gus06.entity.gus.feature.op.pipenext.i;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}


	private Service it;
	private Service ip;
	
	public EntityImpl() throws Exception
	{
		it = Outside.service(this,"gus.feature.wrap.it.i");
		ip = Outside.service(this,"gus.feature.wrap.ip.e");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		I i = (I) o[0];
		
		if(o[1] instanceof P) return ip.t(o);
		if(o[1] instanceof T) return it.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
}
