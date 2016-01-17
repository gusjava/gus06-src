package gus06.manager.gus.gyem.m057.t.rulefinder.mapping;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		
		Map map0 = (Map) ((G) module(M058_G_RULEFINDER_MAPPING_MAPS)).g();
		if(entityName!=null && map0.containsKey(entityName))
			return map0.get(entityName);
		
		return ((G) module(M045_G_MAPPING)).g();
	}
}