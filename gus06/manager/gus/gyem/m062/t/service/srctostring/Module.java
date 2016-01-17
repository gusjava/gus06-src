package gus06.manager.gus.gyem.m062.t.service.srctostring;

import gus06.framework.Entity;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Entity entity = (Entity) o[0];
		String id = (String) o[1];
		
		String entityName = (String) ((T) module(M044_T_ENTITY_FINDNAME)).t(entity);
		
		return entityName+"@"+id;
	}
}