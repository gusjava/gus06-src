package gus06.manager.gus.gyem.m053.t.manager.service;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Object result = ((T) module(M054_T_MANAGER_RESOURCE)).t(obj);
		return ((T) module(M059_T_SERVICE_WRAPPER)).t(new Object[]{result,obj});
	}
}