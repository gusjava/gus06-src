package gus06.manager.gus.gyem.m124.t.module.builder;

import gus06.manager.gus.gyem.GyemSystem;
import gus06.framework.*;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		String value = (String) obj;
		
		T unique = (T) module(M026_T_ENTITY_UNIQUE);
		G empty = (G) module(M060_G_SERVICE_WRAPPER_EMPTY);
		
		if(value.equals("null")) return empty.g();
		return unique.t(value);
	}
}