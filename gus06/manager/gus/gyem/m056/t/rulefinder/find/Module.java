package gus06.manager.gus.gyem.m056.t.rulefinder.find;

import java.util.Map;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Map mapping = (Map) o[0];
		String entityName = (String) o[1];
		String id = (String) o[2];
		
		if(entityName==null)
		{
			if(mapping.containsKey("@"+id))
	        	return mapping.get("@"+id);
	        return id;
		}
		
		String pseudo = entityName.split("\\.")[0];
		
		if(mapping.containsKey(entityName+"@"+id))
			return mapping.get(entityName+"@"+id);
        if(mapping.containsKey(pseudo+"@"+id))
        	return mapping.get(pseudo+"@"+id);
        if(mapping.containsKey("@"+id))
        	return mapping.get("@"+id);
        return id;
	}
}