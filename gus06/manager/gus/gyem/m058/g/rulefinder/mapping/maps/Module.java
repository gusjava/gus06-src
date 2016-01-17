package gus06.manager.gus.gyem.m058.g.rulefinder.mapping.maps;

import java.util.Map;

import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	
	private Map map;
	
	public Object g() throws Exception
	{
		if(map==null) init();
		return map;
	}
	
	
	private void init() throws Exception
	{
		map = (Map) ((T) module(M104_T_BUILD_MAP)).t("entitymappings");
	}
}