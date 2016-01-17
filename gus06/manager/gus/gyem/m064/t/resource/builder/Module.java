package gus06.manager.gus.gyem.m064.t.resource.builder;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String rule = (String) o[0];
		Object src = o[1];
		
		String[] n = (String[]) ((T) module(M065_T_RESOURCE_BUILDER_ANALYZE)).t(rule);
		if(n.length!=2) throw new Exception("Wrong info number: "+n.length);
		
		String builderId = n[0];
		String buildInfo = n[1];
		
		T builder = (T) ((T) module(M066_T_RESOURCE_BUILDER_FINDRB)).t(builderId);
		return builder.t(new Object[]{buildInfo,src});
	}
}