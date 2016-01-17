package gus06.manager.gus.gyem.m013.f.prop.bool.df;

import java.util.Map;

import gus06.framework.F;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements F {
	
	public static final boolean DEFAULT_VALUE = false;

	public boolean f(Object obj) throws Exception
	{
		String key = (String) obj;
		Map prop = (Map) ((G) module(M012_G_PROP)).g();

		if(prop==null) return DEFAULT_VALUE;
		if(!prop.containsKey(key)) return DEFAULT_VALUE;
		
		String value = (String) prop.get(key);
		return value.toLowerCase().equals("true");
	}
}