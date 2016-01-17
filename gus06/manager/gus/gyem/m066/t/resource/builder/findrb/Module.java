package gus06.manager.gus.gyem.m066.t.resource.builder.findrb;

import java.util.Iterator;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_Java;

public class Module extends GyemSystem implements T {


	public Object t(Object obj) throws Exception
	{
		String id = (String) obj;
		if(Tool_Java.isKeyword(id)) id += "1";

		Iterator it = m.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			if(key.endsWith(".rb."+id)) return get(key);
		}
		throw new Exception("Module not found for builder id ["+id+"]");
	}
}