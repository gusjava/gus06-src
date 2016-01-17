package gus06.manager.gus.gyem.m024.t.entity.provider;

import gus06.framework.F;
import gus06.framework.T;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R {

	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		
		if(entityName.startsWith("*"))
			return ((T) module(M028_T_ENTITY_GENERATOR)).t(entityName.substring(1));
		
		if(entityName.startsWith("+"))
			return ((T) module(M026_T_ENTITY_UNIQUE)).t(entityName.substring(1));
		
		boolean isMultiple = ((F) module(M110_F_ENTITY_ISMULTIPLE)).f(entityName);
		
		if(isMultiple)
			return ((T) module(M028_T_ENTITY_GENERATOR)).t(entityName);
		return ((T) module(M026_T_ENTITY_UNIQUE)).t(entityName);
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
}