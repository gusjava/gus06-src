package gus06.entity.gus.map.keyvalue.collect;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161115";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		Map output = (Map) t(obj);
		
		input.clear();
		input.putAll(output);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		T t = (T) o[1];
		
		Map output = new HashMap();
		Iterator it = input.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			Object value = input.get(key);
			
			output.put(t.t(key),t.t(value));
		}
		return output;
	}
}
