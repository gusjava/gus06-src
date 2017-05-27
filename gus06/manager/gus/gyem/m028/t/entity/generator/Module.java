package gus06.manager.gus.gyem.m028.t.entity.generator;

import gus06.framework.T;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_Entity;

public class Module extends GyemSystem implements T, R {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		Class entityClass = (Class) ((T) module(M029_T_ENTITY_CLASSFINDER)).t(entityName);
		return Tool_Entity.createEntity(entityClass,apiMode);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
}