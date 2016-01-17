package gus06.manager.gus.gyem.m012.g.prop;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.P;
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
		prop = (Map) ((T) module(M104_T_BUILD_MAP)).t(MAPNAME_PROP);
		
		Map p1 = (Map) ((G) module(M015_G_PROP_INSIDE)).g();
		Map p2 = (Map) ((G) module(M017_G_PROP_OUTSIDE)).g();
		
		if(p1!=null) prop.putAll(p1);
		if(p2!=null) prop.putAll(p2);
		
		((P) module(M020_P_PROP_COMPLETE)).p(prop);
	}
}