package gus06.manager.gus.gyem.m104.t.build.map;

import gus06.framework.T;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.SupportMap;

public class Module extends GyemSystem implements T, G {

	public Object t(Object obj) throws Exception
	{return new SupportMap((String) obj);}
	
	
	public Object g() throws Exception
	{return new SupportMap("default");}
}