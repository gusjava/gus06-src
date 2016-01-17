package gus06.manager.gus.gyem.m045.g.mapping;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.P;
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
		mapping = (Map) ((T) module(M104_T_BUILD_MAP)).t(MAPNAME_MAPPING);
		
		Map m1 = (Map) ((G) module(M046_G_MAPPING_INSIDE)).g();
		Map m2 = (Map) ((G) module(M048_G_MAPPING_OUTSIDE)).g();
		
		if(m1!=null) mapping.putAll(m1);
		if(m2!=null) mapping.putAll(m2);
		
		((P) module(M051_P_MAPPING_COMPLETE)).p(mapping);
	}
}