package gus06.entity.gus.map.key.keepall;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151124";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		F f = (F) o[1];
		
		Map output = new HashMap();
		Iterator it = input.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = input.get(key);
			
			if(f.f(key)) output.put(key,value);
		}
		
		input.clear();
		input.putAll(output);
	}
}
