package gus06.manager.gus.gyem.m008.g.params;

import java.util.HashMap;
import java.util.Map;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private Map params;
	
	public Object g() throws Exception
	{
		if(params==null) init();
		return params;
	}
	
	
	private void init() throws Exception
	{
		params = new HashMap();
		
		String[] args = (String[]) ((G) module(M007_G_ARGS)).g();

		for(String arg:args) if(arg.contains("="))
		{
			String[] n = arg.split("=",2);
			String key = n[0];
			String value = n[1];

			if(params.containsKey(key))
				throw new Exception("Param ["+key+"] is found may times inside args");
			params.put(key,value);
		}
	}
}