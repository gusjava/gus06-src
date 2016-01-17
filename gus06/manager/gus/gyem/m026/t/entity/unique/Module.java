package gus06.manager.gus.gyem.m026.t.entity.unique;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R {

	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		
		Map map = (Map) ((G) module(M027_G_ENTITY_UNIQUEMAP)).g();
		
		if(!map.containsKey(entityName))
			map.put(entityName,((T) module(M028_T_ENTITY_GENERATOR)).t(entityName));
		return map.get(entityName);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
}