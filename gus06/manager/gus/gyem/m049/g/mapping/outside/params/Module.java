package gus06.manager.gus.gyem.m049.g.mapping.outside.params;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem  implements G {
	
	public static final String START = "m.";

	public Object g() throws Exception
	{
		Map map = new HashMap();
		
		Map params = (Map) ((G) module(M008_G_PARAMS)).g();
		Iterator it = params.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			if(key.startsWith(START))
			map.put(key.substring(START.length()),params.get(key));
		}
		
		return map;
	}
}