package gus06.manager.gus.gyem.m016.g.prop.inside.resourceid;

import java.util.Map;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	public Object g() throws Exception
	{
		Map params = (Map) ((G) module(M008_G_PARAMS)).g();
		
		if(params.containsKey("prop"))
			return params.get("prop");
		
		return "prop";
	}
}