package gus06.manager.gus.gyem.m086.t.rb.newentity;

import java.util.HashMap;
import java.util.Map;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {
	
	private Map cache = new HashMap();
	

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String buildInfo = (String) o[0];
		Object src = o[1];

		String srcString = (String) ((T) module(M062_T_SERVICE_SRCTOSTRING)).t(src);
		if(cache.containsKey(srcString))
			return cache.get(srcString);
		
		Object entity = ((T) module(M028_T_ENTITY_GENERATOR)).t(buildInfo);
		cache.put(srcString, entity);
		return entity;
	}
}