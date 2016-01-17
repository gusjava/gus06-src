package gus06.manager.gus.gyem.m017.g.prop.outside;

import java.util.HashMap;
import java.util.Map;

import gus06.framework.G;
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
		prop = new HashMap();

		Map p1 = (Map) ((G) module(M019_G_PROP_OUTSIDE_FILE)).g();
		Map p2 = (Map) ((G) module(M018_G_PROP_OUTSIDE_PARAMS)).g();
		
		if(p1!=null) prop.putAll(p1);
		if(p2!=null) prop.putAll(p2);
	}
}