package gus06.manager.gus.gyem.m054.t.manager.resource;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		String rule = (String) ((T) module(M055_T_RULEFINDER)).t(obj);
		return ((T) module(M063_T_RESOURCE_PROVIDER)).t(new Object[]{rule,obj});
	}
}