package gus06.manager.gus.gyem.m043.t.entity.nametopath;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_Entity;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		Tool_Entity.checkEntityName(entityName);
		return ENTITYCLASS_START + entityName + ENTITYCLASS_END;
	}
}