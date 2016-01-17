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
		Map cust = buildCustomizedMap();
		Iterator it = cust.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			put(key,cust.get(key));
		}
	}
	
	
	
	
	
	private Map buildCustomizedMap() throws Exception
	{
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		T unique = (T) module(M026_T_ENTITY_UNIQUE);
		G empty = (G) module(M060_G_SERVICE_WRAPPER_EMPTY);
		
		Map map = new HashMap();
		Iterator it = prop.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			if(key.startsWith("cust."))
			{
				String value = (String) prop.get(key);
				Object newModule = value.equals("null")?empty.g():unique.t(value);
				map.put(key.substring(5),newModule);
			}
		}
		return map;
	}
}