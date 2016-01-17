package gus06.manager.gus.gyem.m046.g.mapping.inside;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private Map mapping;
	
	public Object g() throws Exception 
	{
		if(mapping==null) init();
		return mapping;
	}

	
	private void init() throws Exception 
	{
		String resourceId = (String) ((G) module(M047_G_MAPPING_INSIDE_RESOURCEID)).g();
		mapping = (Map) ((T) module(M011_T_INSIDE_PROPLOADER)).t(resourceId);
	}
}