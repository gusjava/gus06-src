package gus06.manager.gus.gyem.m079.t.rb.call.t;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String buildInfo = (String) o[0];
		Object src = o[1];
		
		String[] n = buildInfo.split(" ",2);
		if(n.length!=2) throw new Exception("Invalid build info: "+buildInfo);
		
		String info1 = n[0];
		String info2 = n[1];
		
		Object result1 = ((T) module(M054_T_MANAGER_RESOURCE)).t(new Object[]{null,info1});
		Object result2 = ((T) module(M054_T_MANAGER_RESOURCE)).t(new Object[]{null,info2});
		
		if(!(result1 instanceof T)) throw new Exception("Invalid resource type: "+result1.getClass().getName());
		
		return ((T) result1).t(result2);
	}
}