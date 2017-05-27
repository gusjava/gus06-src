package gus06.entity.gus.map.key.check.any;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160927";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.feature.op.col.hasany.mapkey.f");}

	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		F filter = (F) o[1];
		
		F f = (F) perform.t(filter);
		return f.f(input);
	}
}
