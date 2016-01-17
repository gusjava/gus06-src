package gus06.manager.gus.gyem.m077.t.rb.call.g;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String buildInfo = (String) o[0];
		Object src = o[1];
		
		Object result = ((T) module(M054_T_MANAGER_RESOURCE)).t(new Object[]{null,buildInfo});
		if(!(result instanceof G)) throw new Exception("Invalid resource type: "+result.getClass().getName());
		
		return ((G) result).g();
	}
}