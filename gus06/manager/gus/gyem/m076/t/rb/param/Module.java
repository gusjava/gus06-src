package gus06.manager.gus.gyem.m076.t.rb.param;

import java.util.Map;

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
		
		
		Map param = (Map) ((G) module(M008_G_PARAMS)).g();
		
		if(param==null) return null;
		if(!param.containsKey(buildInfo)) return null;
		
		return param.get(buildInfo);
	}
}