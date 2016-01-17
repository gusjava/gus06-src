package gus06.manager.gus.gyem.m075.t.rb.property;

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
		
		
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		
		if(prop==null) return null;
		if(!prop.containsKey(buildInfo)) return null;
		
		return prop.get(buildInfo);
	}
}