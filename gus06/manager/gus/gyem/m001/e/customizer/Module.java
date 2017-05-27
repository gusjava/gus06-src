package gus06.manager.gus.gyem.m001.e.customizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gus06.framework.E;
import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements E {

	
	public void e() throws Exception
	{
		Map cust = buildCust();
		Iterator it = cust.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			put(key,cust.get(key));
		}
	}
	
	
	
	private Map buildCust() throws Exception
	{
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		T builder = (T) module(M124_T_MODULE_BUILDER);
		
		Map map = new HashMap();
		Iterator it = prop.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			if(key.startsWith("cust."))
			{
				String value = (String) prop.get(key);
				
				String name = key.substring(5);
				Object newModule = builder.t(value);
				map.put(name,newModule);
			}
		}
		return map;
	}
}