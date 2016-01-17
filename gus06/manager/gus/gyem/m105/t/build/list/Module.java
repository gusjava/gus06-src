package gus06.manager.gus.gyem.m105.t.build.list;

import gus06.framework.T;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.SupportList;

public class Module extends GyemSystem implements T, G {

	public Object t(Object obj) throws Exception
	{return new SupportList((String) obj);}
	
	
	public Object g() throws Exception
	{return new SupportList("default");}
}