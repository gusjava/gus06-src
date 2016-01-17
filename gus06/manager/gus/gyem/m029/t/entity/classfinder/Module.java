package gus06.manager.gus.gyem.m029.t.entity.classfinder;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.F;
import gus06.framework.T;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		Map map = (Map) ((G) module(M030_G_ENTITY_CLASSMAP)).g();
		
		if(!map.containsKey(entityName))
			((F) module(M031_F_ENTITY_LOADER)).f(entityName);
		
		if(!map.containsKey(entityName))
			throw new Exception("Class not found for entity: "+entityName);
			
		return map.get(entityName);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
}