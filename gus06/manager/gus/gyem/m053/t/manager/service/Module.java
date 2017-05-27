package gus06.manager.gus.gyem.m053.t.manager.service;

import gus06.framework.F;
import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		if(((F) module(M013_F_PROP_BOOL_DF)).f(PROP_APPDYNAMICCALL))
		{
			Wrapper w = new Wrapper(obj);
			return ((T) module(M123_T_SERVICE_WRAPPER_DYN)).t(new Object[]{w,obj});
		}
		
		Object result = ((T) module(M054_T_MANAGER_RESOURCE)).t(obj);
		return ((T) module(M059_T_SERVICE_WRAPPER)).t(new Object[]{result,obj});
	}
	
	private class Wrapper implements G
	{
		private Object input;
		public Wrapper(Object input) {this.input = input;}
		
		public Object g() throws Exception
		{return ((T) module(M054_T_MANAGER_RESOURCE)).t(input);}
	}
}