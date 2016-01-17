package gus06.manager.gus.gyem.m047.g.mapping.inside.resourceid;

import java.util.Map;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	public Object g() throws Exception
	{
		Map params = (Map) ((G) module(M008_G_PARAMS)).g();
		
		if(params.containsKey("mapping"))
			return params.get("mapping");
		
		Map prop = (Map) ((G) module(M015_G_PROP_INSIDE)).g();
		
		if(prop.containsKey("mapping"))
			return prop.get("mapping");
		
		return "mapping";
	}
}