package gus06.manager.gus.gyem.m011.t.inside.proploader;

import java.util.HashMap;
import java.util.Map;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		String seq = (String) obj;
		Map prop = new HashMap();
		String[] n = seq.split(";");
		for(int i=0;i<n.length;i++)
		{
			Map m = (Map) ((T) module(M009_T_INSIDE)).t("prop."+n[i]);
			if(m!=null) prop.putAll(completeMap(m));
		}
		return prop;
	}

	

	
	private Map completeMap(Map map) throws Exception
	{
		if(!map.containsKey("model")) return map;
		String model = (String) map.get("model");
		map.remove("model");
		
		Map modelMap = (Map) t(model);
		modelMap.putAll(map);
		return modelMap;
	}
}