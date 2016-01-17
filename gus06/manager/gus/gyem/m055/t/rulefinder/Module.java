package gus06.manager.gus.gyem.m055.t.rulefinder;

import java.util.Map;

import gus06.framework.Entity;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Entity entity = (Entity) o[0];
		String id = (String) o[1];
		
		String entityName = (String) ((T) module(M044_T_ENTITY_FINDNAME)).t(entity);
		
		if(id==null)        throw new Exception("Invalid call for entity ["+entityName+"]: null id");
        if(id.equals(""))   throw new Exception("Invalid call for entity ["+entityName+"]: empty id");
        
        Map mapping = (Map) ((T) module(M057_T_RULEFINDER_MAPPING)).t(entityName);
		String rule = (String) ((T) module(M056_T_RULEFINDER_FIND)).t(new Object[]{mapping,entityName,id});
		
		if(mapping.containsKey(rule))
			rule = (String) mapping.get(rule);
		
		if(rule.equals(""))  throw new Exception("Empty mapping rule found for source ["+entityName+"@"+id+"]");
		
		return rule;
	}
}