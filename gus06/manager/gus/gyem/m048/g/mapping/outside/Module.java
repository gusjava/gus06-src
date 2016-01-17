package gus06.manager.gus.gyem.m048.g.mapping.outside;

import java.util.HashMap;
import java.util.Map;

import gus06.framework.G;
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
		mapping = new HashMap();

		Map m1 = (Map) ((G) module(M050_G_MAPPING_OUTSIDE_FILE)).g();
		Map m2 = (Map) ((G) module(M049_G_MAPPING_OUTSIDE_PARAMS)).g();
		
		if(m1!=null) mapping.putAll(m1);
		if(m2!=null) mapping.putAll(m2);
	}
}