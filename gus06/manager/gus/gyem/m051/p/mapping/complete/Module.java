package gus06.manager.gus.gyem.m051.p.mapping.complete;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import gus06.framework.G;
import gus06.framework.P;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;

public class Module extends GyemSystem implements P {

	public void p(Object obj) throws Exception
	{
		Map mapping = (Map) obj;
		
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		
		Iterator it = prop.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			if(key.startsWith("mapping."))
				mapping.put(key.substring(8),prop.get(key));
		}
		
		if(prop.containsKey(PROP_SEQ_MAPPING))
		{
			String s = (String) prop.get(PROP_SEQ_MAPPING);
			String[] nn = s.split(";");
			for(String n:nn) mapping.putAll(loadFromPath(n));
		}
	}

	
	
	private Map loadFromPath(String path) throws Exception
	{
		File file = (File) ((R) module(M102_R_FILEPROVIDER)).r(path);
		if(file==null || !file.isFile()) throw new Exception("File not found for path id="+path);
		return Tool_File.prop(file);
	}
}