package gus06.manager.gus.gyem.m031.f.entity.loader;

import java.util.Map;

import gus06.framework.F;
import gus06.framework.G;
import gus06.framework.P;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements F {

	public boolean f(Object obj) throws Exception
	{
		String entityName = (String) obj;
		
		Map map = (Map) ((G) module(M030_G_ENTITY_CLASSMAP)).g();
		if(map.containsKey(entityName)) return false;
		
		((P) module(M032_P_ENTITY_LOADER_SECURITY)).p(entityName);
		((P) module(M033_P_ENTITY_LOADER_PARAM)).p(entityName);
		
		Class c = (Class) ((T) module(M034_T_ENTITY_CLASS1_LOAD)).t(entityName);
		map.put(entityName,c);
		
		return true;
	}
}