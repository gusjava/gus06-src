package gus06.manager.gus.gyem.m015.g.prop.inside;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private Map prop;
	
	public Object g() throws Exception 
	{
		if(prop==null) init();
		return prop;
	}

	
	private void init() throws Exception 
	{
		String resourceId = (String) ((G) module(M016_G_PROP_INSIDE_RESOURCEID)).g();
		prop = (Map) ((T) module(M011_T_INSIDE_PROPLOADER)).t(resourceId);
	}
}